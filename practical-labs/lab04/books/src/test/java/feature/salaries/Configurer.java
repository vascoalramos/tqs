package feature.salaries;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import salaries.Employee;

import java.util.Locale;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:23
 */

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(Employee.class, (TableEntryTransformer<Employee>) entry -> {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(entry.get("id")));
            employee.setUser(entry.get("user"));
            employee.setSalary(Float.parseFloat(entry.get("salary")));
            return employee;
        }));

    }


    public Locale locale() {
        return Locale.ENGLISH;
    }

}