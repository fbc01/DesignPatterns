package BuilderDesignPattern;

import java.time.LocalDate;

public class Director {

    public static void buildUserDTO() {
        UserDTOBuilder userDTOBuilder = new UserWebDTOBuilder();

        Address address = new Address();
        address.setHouseNumber("21");
        address.setStreet("Times Square Road");
        address.setCity("New York City");
        address.setZipcode("123456");
        address.setState("New York");

        User user = new User();
        user.setFirstName("Lionel");
        user.setLastName("Maradona");
        user.setBirthday(LocalDate.of(1990, 12, 25));
        user.setAddress(address);

        userDTOBuilder
            .withFirstName(user.getFirstName())
            .withLastName(user.getLastName())
            .withBirthday(user.getBirthday())
            .withAddress(user.getAddress())
            .build();

        UserDTO userDTO = userDTOBuilder.getUserDTO();
        System.out.println(userDTO);
    }
}
