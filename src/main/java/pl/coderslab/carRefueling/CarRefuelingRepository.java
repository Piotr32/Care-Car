package pl.coderslab.carRefueling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRefuelingRepository extends JpaRepository<CarRefueling, Long> {


    @Modifying
    @Query(value = "update carRefueling set carData_id = null where carData_id = ?1", nativeQuery = true)
    public void deleteCarDataRalation(Long id);

    @Query(value = "select * from carRefueling where carRefueling.user_id =:user_id", nativeQuery = true)
    List<CarRefueling> findByCarRefuelingByUserIdQuery(@Param("user_id") Long id);


    }
