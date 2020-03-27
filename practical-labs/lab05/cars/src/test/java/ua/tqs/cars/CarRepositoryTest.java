package ua.tqs.cars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 16:22
 */

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void whenFindByName_thenReturnCar() {
        Car ford = new Car("mustang", "Ford");
        entityManager.persistAndFlush(ford);

        Car found = carRepository.findByName(ford.getName());
        assertThat((found.getName())).isEqualTo(ford.getName());
    }

    @Test
    void whenInvalidName_thenReturnNull() {
        Car found = carRepository.findByName("ABC");
        assertThat(found).isNull();
    }
}