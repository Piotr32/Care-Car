package pl.coderslab.carHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.carRefueling.CarRefueling;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarHistoryService {

    private CarHistoryRepository carHistoryRepository;

    @Autowired
    public CarHistoryService(CarHistoryRepository carHistoryRepository) {
        this.carHistoryRepository = carHistoryRepository;
    }

    public void saveCarHistory(CarHistory carHistory){
        carHistoryRepository.save(carHistory);
    }

    public void updateCarHistory(CarHistory carHistory){
        carHistoryRepository.save(carHistory);
    }

    public CarHistory findCarHistory(Long id){
        return carHistoryRepository.findById(id).orElse(null);
    }

    public List<CarHistory> findAllCarHistory(){
        return carHistoryRepository.findAll();
    }

    public double getExpensesHistoryCost(){
        List<CarHistory> expensesList = findAllCarHistory();
        double sum = 0;
        for (CarHistory expenses : expensesList) {
            sum += expenses.getExpenses();
        }
        return sum;
    }

    public void deleteCarHistory(Long id) {
        carHistoryRepository.deleteCarDataRalation(id);
        carHistoryRepository.deleteById(id);
    }

}


