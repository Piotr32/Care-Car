package pl.coderslab.carHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarHistoryRepository extends JpaRepository<CarHistory, Long> {

    @Modifying
    @Query(value = "update carHistory set carData_id = null where carData_id = ?1", nativeQuery = true)
    public void deleteCarDataRalation(Long id);
}
