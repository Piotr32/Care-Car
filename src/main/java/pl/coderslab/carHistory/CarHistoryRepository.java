package pl.coderslab.carHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.carData.CarData;

import java.util.List;

public interface CarHistoryRepository extends JpaRepository<CarHistory, Long> {

    @Modifying
    @Query(value = "update carHistory set carData_id = null where carData_id = ?1", nativeQuery = true)
    public void deleteCarDataRalation(Long id);

    @Query(value = "select * from carHistory where carHistory.user_id =:user_id", nativeQuery = true)
    List<CarHistory> findByCarHistoryByUserIdQuery(@Param("user_id") Long id);
}
