package pl.coderslab.carData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarDataRepository extends JpaRepository<CarData, Long> {

    @Modifying
    @Query(value = "update carData set user_id = null where id = ?1", nativeQuery = true)
    public void deleteUserRalation(Long id);
}
