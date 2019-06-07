package pl.coderslab.carHistory;


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
@RequestMapping("/carHistory")
public class CarHistoryController {

    private CarHistoryService carHistoryService;
    private CarDataService carDataService;

    @Autowired
    public CarHistoryController(CarHistoryService carHistoryService, CarDataService carDataService) {
        this.carHistoryService = carHistoryService;
        this.carDataService = carDataService;
    }

    @GetMapping("/add")
    public String addCarHistory(Model model) {
        model.addAttribute("carHistory", new CarHistory());
        model.addAttribute("carDataList", carDataService.findAll());
        return "carHistory";
    }

    @PostMapping("/add")
    public String addCarHistory(@ModelAttribute @Valid CarHistory carHistory, BindingResult result, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        carHistory.setUser(user);
        if (result.hasErrors()) {
            return "carHistory";
        }
        carHistoryService.saveCarHistory(carHistory);
        return "redirect:list";
    }



    @GetMapping(value = "/list", produces = "text/html; charset=UTF-8")
    public String carHistoryList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        List<CarHistory> carHistory = carHistoryService.findByCarHistoryByUserIdQuery(user.getId());
        model.addAttribute("carHistory", carHistory);
        model.addAttribute("totalExpenses",carHistoryService.getExpensesHistoryCost());
        return "carHistoryList";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        CarHistory carHistory = carHistoryService.findCarHistory(id);
        model.addAttribute("carHistory", carHistory);
        return "carHistory";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute @Valid CarHistory carHistory, @PathVariable Long id, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "carHistory";

        }
        CarData carData = carDataService.findCarData(id);
        model.addAttribute("carData", carData);
        carHistoryService.updateCarHistory(carHistory);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carHistoryService.deleteCarHistory(id);
        return "redirect:../list";
    }
}

