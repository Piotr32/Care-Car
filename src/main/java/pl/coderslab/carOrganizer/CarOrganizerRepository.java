package pl.coderslab.carOrganizer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.carHistory.CarHistory;

import java.util.List;

public interface CarOrganizerRepository extends JpaRepository<CarOrganizer, Long> {


    @Modifying
    @Query(value = "update carOrganizer set carData_id = null where carData_id = ?1", nativeQuery = true)
    public void deleteCarDataRalation(Long id);

    @Query(value = "select * from carOrganizer where carOrganizer.date>=current_date order by carOrganizer.date limit 1", nativeQuery = true)
    public CarOrganizer findClosest();

    @Query(value = "select * from carOrganizer where carOrganizer.user_id =:user_id", nativeQuery = true)
    List<CarOrganizer> findByCarOrganizerByUserIdQuery(@Param("user_id") Long id);
}
