package ua.tqs.cars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class CarsApplicationTests {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestRestTemplate restClient;

    @BeforeEach
    public void setUpTestCars() {
        repository.saveAndFlush(new Car("zoe", "renault"));
        repository.saveAndFlush(new Car("prius", "toyota"));
    }

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
	void getCar_returnsCarDetailsTest() {
		ResponseEntity<Car> entity = restClient.getForEntity("/api/cars/prius", Car.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getName()).isEqualTo("prius");
	}


    @Test
    void contextLoads() {
    }

}
