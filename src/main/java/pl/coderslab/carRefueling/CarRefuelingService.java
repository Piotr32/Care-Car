package pl.coderslab.carRefueling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarRefuelingService {

    private CarRefuelingRepository carRefuelingRepository;

    @Autowired
    public CarRefuelingService(CarRefuelingRepository carRefuelingRepository) {
        this.carRefuelingRepository = carRefuelingRepository;
    }

    public void saveCarRefueling(CarRefueling carRefueling){
        carRefuelingRepository.save(carRefueling);
    }

    public void updateCarRefueling(CarRefueling carRefueling){
        carRefuelingRepository.save(carRefueling);
    }

    public CarRefueling findCarRefueling(Long id){
        return carRefuelingRepository.findById(id).orElse(null);
    }

    public List<CarRefueling> findAllCarRefueling(){
        return carRefuelingRepository.findAll();
    }

    public double getTotalRefuelingCost(){
        List<CarRefueling> refuelingList = findAllCarRefueling();
        double sum = 0;
        for (CarRefueling refueling : refuelingList) {
            sum += refueling.getTotal();
        }
        return sum;
    }

    public void deleteCarRefueling(Long id) {
        carRefuelingRepository.deleteCarDataRalation(id);
        carRefuelingRepository.deleteById(id);
    }

    public List<CarRefueling> findByCarRefuelingByUserIdQuery(Long id) {
        return carRefuelingRepository.findByCarRefuelingByUserIdQuery(id);
    }

}
