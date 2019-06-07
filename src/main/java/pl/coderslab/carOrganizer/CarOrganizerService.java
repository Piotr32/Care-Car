package pl.coderslab.carOrganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.carHistory.CarHistory;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarOrganizerService {

    private CarOrganizerRepository carOrganizerRepository;

    @Autowired
    public CarOrganizerService(CarOrganizerRepository carOrganizerRepository) {
        this.carOrganizerRepository = carOrganizerRepository;
    }

    public void saveCarOrganizer(CarOrganizer carOrganizer){
        carOrganizerRepository.save(carOrganizer);
    }

    public void updateCarOrganizer(CarOrganizer carOrganizer){
        carOrganizerRepository.save(carOrganizer);
    }

    public CarOrganizer findCarOrganizer(Long id){
        return carOrganizerRepository.findById(id).orElse(null);
    }

    public List<CarOrganizer> findAllCarOrganizer(){
        return carOrganizerRepository.findAll();
    }

    public double getExpensesOrganizerCost(){
        List<CarOrganizer> expensesList = findAllCarOrganizer();
        double sum = 0;
        for (CarOrganizer expenses : expensesList) {
            sum += expenses.getExpenses();
        }
        return sum;
    }

    public void deleteCarOrganizer(Long id) {
        carOrganizerRepository.deleteCarDataRalation(id);
        carOrganizerRepository.deleteById(id);
    }

    public CarOrganizer findClosest(){return carOrganizerRepository.findClosest();}

    public List<CarOrganizer> findByCarOrganizerByUserIdQuery(Long id) {
        return carOrganizerRepository.findByCarOrganizerByUserIdQuery(id);
    }
}

