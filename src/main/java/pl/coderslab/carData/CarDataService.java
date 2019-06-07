package pl.coderslab.carData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CarDataService {

    private pl.coderslab.carData.CarDataRepository carDataRepository;

    @Autowired
    public CarDataService(CarDataRepository carDataRepository) {
        this.carDataRepository = carDataRepository;
    }

    public void saveCarData(CarData carData) {
        carDataRepository.save(carData);
    }

    public void updateCarData(CarData carData) {
        carDataRepository.save(carData);
    }

    public CarData findCarData(Long id) {
        return carDataRepository.findById(id).orElse(null);
    }

    public void deleteCarData(Long id) {
        carDataRepository.deleteUserRalation(id);
        carDataRepository.deleteById(id);
    }

    public List<CarData> findAll() {
        return carDataRepository.findAll();
    }

    public List<CarData> findByCarDataByUserIdQuery(Long id) {
        return carDataRepository.findByCarDataByUserIdQuery(id);
    }
}

