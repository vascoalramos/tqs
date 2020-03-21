package ua.tqs.cars;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Vasco Ramos
 * @date 21/03/20
 * @time 15:54
 */

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarService service;

    @Test
    public void givenCar_whenGetCars_thenReturnJsonArray() throws Exception {
            Car tesla = new Car("modelS", "Tesla");

        given(service.getCarDetails("modelS")).willReturn(tesla);

        mvc.perform(get("/api/cars/modelS").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(tesla.getId()))).andExpect(jsonPath("$.name", is(tesla.getName()))).andExpect(jsonPath("$.maker", is(tesla.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getCarDetails("modelS");
        reset(service);

    }
}
