package salaries;

/**
 * @author Vasco Ramos
 * @date 19/03/20
 * @time 13:25
 */

public class Employee {
    private int id;
    private String user;
    private float salary;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(final float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", user=" + user + ", salary=" + salary + "]";
    }
}
