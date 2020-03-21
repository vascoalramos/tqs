package ua.tqs.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 15:52
 */

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(path = "/cars/{carName}")
    public Car getCar(@PathVariable(value = "carName") String name) {
        return this.carService.getCarDetails(name);
    }

}