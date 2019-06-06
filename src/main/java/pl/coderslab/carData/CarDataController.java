package pl.coderslab.carData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carData")
public class CarDataController {

    private CarDataService carDataService;

    @Autowired
    public CarDataController (CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    @GetMapping(value = "/list", produces = "text/html; charset=UTF-8")
    public String getList(Model model) {
        List<CarData> carData = carDataService.findAll();
        model.addAttribute("carData", carData);
        return "carDataList";
    }

    @GetMapping("/add")
    public String addCarData(Model model) {
        model.addAttribute("carData", new CarData());
        return "carData";
    }
    @GetMapping("/carDataPreview/{id}")
    public String carDataPreview(Model model, @PathVariable Long id) {
        CarData carData = carDataService.findCarData(id);
        if(carData!=null) {
            model.addAttribute("car", carData);
            return "carDataPreview";
        }else {
            return "errorFetchData";
        }
    }

    @PostMapping("/add")
    public String addCarData(@ModelAttribute @Valid CarData carData, BindingResult result) {
        if (result.hasErrors()) {
            return "carData";
        }
        carDataService.saveCarData(carData);
        return "redirect:list";
    }
    @ModelAttribute("vehicleType")
    public List<String> getVehicleType() {
        List<String> vehicleType = new ArrayList<>();
        vehicleType.add("Samochód");
        vehicleType.add("Motocykl");
        return vehicleType;
    }
    // Rodzaj paliwa, Petrol, Diesel, Gas (LPG), Electric, Hybrid, Petrol and Gas

    @ModelAttribute("fuelType")
    public List<String> getFuelType() {
        List<String> fuelType = new ArrayList<>();
        fuelType.add("Benzyna");
        fuelType.add("Olej napędowy ");
        fuelType.add("Gaz (LPG)");
        fuelType.add("Elektryczny");
        fuelType.add("Hybrydowy");
        return fuelType;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        CarData carData = carDataService.findCarData(id);
        model.addAttribute("carData", carData);
        return "carData";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid CarData carData, BindingResult result) {
        if (result.hasErrors()) {
            return "carData";
        }
        carDataService.updateCarData(carData);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "redirect:../list";
    }

}

