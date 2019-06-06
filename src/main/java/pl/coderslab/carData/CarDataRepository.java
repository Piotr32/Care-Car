package pl.coderslab.carData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDataRepository extends JpaRepository<CarData, Long> {
}
