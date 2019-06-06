package pl.coderslab.carRefueling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarRefuelingRepository extends JpaRepository<CarRefueling, Long> {


        @Modifying
        @Query(value = "update carRefueling set carData_id = null where carData_id = ?1", nativeQuery = true)
        public void deleteCarDataRalation(Long id);


    }
