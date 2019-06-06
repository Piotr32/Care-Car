package pl.coderslab.carHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarHistoryRepository extends JpaRepository<CarHistory, Long> {
}
