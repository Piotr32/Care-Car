package pl.coderslab.carData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CarDataRepository extends JpaRepository<CarData, Long> {

    @Modifying
    @Query(value = "update carData set user_id = null where id = ?1", nativeQuery = true)
    public void deleteUserRalation(Long id);

    @Query(value = "select * from carData where carData.user_id =:user_id", nativeQuery = true)
    List<CarData> findByCarDataByUserIdQuery(@Param("user_id") Long id);
}
