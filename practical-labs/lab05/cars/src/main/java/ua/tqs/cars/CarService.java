package ua.tqs.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 15:50
 */

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarDetails(String name) {
        return carRepository.findByName(name);
    }
}
