package pl.coderslab.carOrganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.carData.CarData;
import pl.coderslab.carData.CarDataService;
import pl.coderslab.user.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/carOrganizer")
public class CarOrganizerController {

    private CarOrganizerService carOrganizerService;
    private CarDataService carDataService;

    @Autowired
    public CarOrganizerController(CarOrganizerService carOrganizerService, CarDataService carDataService) {
        this.carOrganizerService = carOrganizerService;
        this.carDataService = carDataService;
    }

    @GetMapping("/add")
    public String addCarOrganizer(Model model) {
        model.addAttribute("carOrganizer", new CarOrganizer());
        model.addAttribute("carDataList", carDataService.findAll());
        return "carOrganizer";
    }

    @PostMapping("/add")
    public String addCarOrganizer(@ModelAttribute @Valid CarOrganizer carOrganizer, BindingResult result, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        carOrganizer.setUser(user);
        if (result.hasErrors()) {
            return "carOrganizer";
        }
        carOrganizerService.saveCarOrganizer(carOrganizer);
        return "redirect:list";
    }

    @GetMapping(value = "/list", produces = "text/html; charset=UTF-8")
    public String carOrganizerList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        List<CarOrganizer> carOrganizer = carOrganizerService.findByCarOrganizerByUserIdQuery(user.getId());
        model.addAttribute("carOrganizer", carOrganizer);
        model.addAttribute("totalExpenses",carOrganizerService.getExpensesOrganizerCost());
        model.addAttribute("date", carOrganizerService.findClosest());
        return "carOrganizerList";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        CarOrganizer carOrganizer = carOrganizerService.findCarOrganizer(id);
        model.addAttribute("carOrganizer", carOrganizer);
        return "carOrganizer";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid CarOrganizer carOrganizer, @PathVariable Long id, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "carOrganizer";

        }
        CarData carData = carDataService.findCarData(id);
        model.addAttribute("carData", carData);
        carOrganizerService.updateCarOrganizer(carOrganizer);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carOrganizerService.deleteCarOrganizer(id);
        return "redirect:../list";
    }
}
