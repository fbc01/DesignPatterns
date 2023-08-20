package BuilderDesignPattern;

import java.time.LocalDate;
import java.time.Period;

/**
 * In real world applications, Builder class of a Product is usually defined
 * as an inner class of the same product class. And to make the product class
 * immutable, we set the setter methods as private. In this way, only the inner
 * builder class can use the setter methods.
 */
public class UserWebDTOBuilder implements UserDTOBuilder{

    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDTO userWebDTO;

    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate birthday) {
        Period age = Period.between(birthday, LocalDate.now());
        this.age = Integer.toString(age.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address.getHouseNumber() + " , " + address.getStreet() + " \n " +
                address.getCity() + " , " + address.getZipcode() + " , " + address.getState();
        return this;
    }

    @Override
    public void build() {
        String name = firstName + " " + lastName;
        userWebDTO = new UserWebDTO(name, address, age);
    }

    @Override
    public UserDTO getUserDTO() {
        return userWebDTO;
    }
}
