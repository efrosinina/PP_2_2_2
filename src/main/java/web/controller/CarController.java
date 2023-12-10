package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;
import web.service.CarServiceImpl;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarService carService = new CarServiceImpl();
    @GetMapping("/cars")
    public String show(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> carList;
        {
            carList = new ArrayList<>();

            carList.add(new Car("Kia", 1, "White"));
            carList.add(new Car("BMW", 2, "Gray"));
            carList.add(new Car("Honda", 3, "Black"));
            carList.add(new Car("Mercedes", 4, "White"));
            carList.add(new Car("Volkswagen", 5, "Black"));
        }
        carList = carService.showList(carList, count);
        model.addAttribute("list", carList);
        return "cars";
    }
}
