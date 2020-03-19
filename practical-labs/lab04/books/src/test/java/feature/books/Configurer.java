package feature.books;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:23
 */

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineParameterType(new ParameterType<>("date_iso_local_date_time", "\\d{4}-\\d{2}-\\d{2}", LocalDateTime.class, (String s) -> LocalDateTime.parse(s.concat("T00:00:00"))));

    }


    public Locale locale() {
        return Locale.ENGLISH;
    }

}