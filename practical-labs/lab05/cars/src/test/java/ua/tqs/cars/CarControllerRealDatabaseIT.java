package ua.tqs.cars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 16:27
 */


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = CarsApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "application-integrationtest.properties")
public class CarControllerRealDatabaseIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }


    @Test
    public void givenCar_whenGetCar_thenStatus200() throws Exception {
        Car ford = new Car("mustang", "Ford");
        repository.saveAndFlush(ford);

        mvc.perform(get("/api/cars/mustang").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.name", is(ford.getName()))).andExpect(jsonPath("$.maker", is(ford.getMaker())));
    }

}
