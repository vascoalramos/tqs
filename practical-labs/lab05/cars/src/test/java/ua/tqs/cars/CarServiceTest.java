package ua.tqs.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 16:20
 */

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp() {
        Car ford = new Car("mustang", "Ford");
        Mockito.when(carRepository.findByName(ford.getName())).thenReturn(ford);
    }

    @Test
    void whenValidName_thenCarShouldBeFound() {
        String name = "mustang";

        Car found = carService.getCarDetails(name);

        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    void whenNonExistingName_thenCarShouldNotExist() {
        String name = "ABC";

        Car found = carService.getCarDetails(name);

        assertThat(found).isNull();

        verifyFindByNameIsCalledOnce(name);
    }

    private void verifyFindByNameIsCalledOnce(String name) {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByName(name);
        Mockito.reset(carRepository);
    }
}