package feature.salaries;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salaries.Employee;
import salaries.SalaryManager;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:22
 */

public class SalarySteps {
    private SalaryManager manager;

    @Given("^the salary management system is initialized with the following data$")
    public void the_salary_management_system_is_initialized_with_the_following_data(final List<Employee> employees) {
        manager = new SalaryManager(employees);
    }

    @When("^the boss increases the salary for the employee with id '(\\d+)' by (\\d+)%$")
    public void the_boss_increases_the_salary_for_the_employee_with_id_by(final int id, final int increaseInPercent) {
        manager.increaseSalary(id, increaseInPercent);
    }

    @Then("^the payroll for the employee with id '(\\d+)' should display a salary of (\\d+)$")
    public void the_payroll_for_the_employee_with_id_should_display_a_salary_of(final int id, final float salary) {
        Employee nominee = manager.getPayroll(id);
        assertThat(nominee.getSalary(), equalTo(salary));
    }
}
