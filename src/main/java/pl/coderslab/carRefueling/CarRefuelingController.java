package pl.coderslab.carRefueling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carData.CarData;
import pl.coderslab.carData.CarDataService;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carRefueling")
public class CarRefuelingController {

    private CarRefuelingService carRefuelingService;
    private CarDataService carDataService;


    @Autowired
    public CarRefuelingController(CarRefuelingService carRefuelingService, CarDataService carDataService) {
        this.carRefuelingService = carRefuelingService;
        this.carDataService = carDataService;
    }

    @GetMapping("/add")
    public String addCarRefueling(Model model) {
        model.addAttribute("carRefueling", new CarRefueling());
        model.addAttribute("carDataList", carDataService.findAll());
        return "carRefueling";
    }

    @PostMapping("/add")
    public String addCarRefueling(@ModelAttribute @Valid CarRefueling carRefueling, BindingResult result) {
        if (result.hasErrors()) {
            return "carRefueling";
        }
        carRefuelingService.saveCarRefueling(carRefueling);
        return "redirect:list";
    }

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

    @GetMapping(value = "/list", produces = "text/html; charset=UTF-8")
    public String CarRefuelingList(Model model){
        List<CarRefueling> carRefueling = carRefuelingService.findAllCarRefueling();
        model.addAttribute("carRefueling", carRefueling);
        model.addAttribute("totalCost",carRefuelingService.getTotalRefuelingCost());
        model.addAttribute("date", carRefuelingService.findClosest());
        return "carRefuelingList";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        CarRefueling carRefueling = carRefuelingService.findCarRefueling(id);
        model.addAttribute("carRefueling", carRefueling);
        return "carRefueling";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid CarRefueling carRefueling, @PathVariable Long id, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "carRefueling";
        }
        CarData carData = carDataService.findCarData(id);
        model.addAttribute("carData", carData);
        carRefuelingService.updateCarRefueling(carRefueling);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carRefuelingService.deleteCarRefueling(id);
        return "redirect:../list";
    }
}






