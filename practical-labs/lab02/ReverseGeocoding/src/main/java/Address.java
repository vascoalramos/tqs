/**
 * @author Vasco Ramos
 * @date 22/02/20
 * @time 09:20
 */

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String houseNumber;

    public Address(String street, String city, String state, String zip, String houseNumber) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip='" + zip + '\'' + ", houseNumber='" + houseNumber + '\'' + '}';
    }
}
