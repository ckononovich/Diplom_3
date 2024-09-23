package model;

public class DataForTests {
    private final String name = "TestName111";
    private final String email = "testemail111@email.com";
    private final String password = "123456";
    private final String wrongPassword = "12345";

    public LoginViewForApi loginViewForApi = new LoginViewForApi(email, password);
    public RegistrationViewForApi registrationViewForApi = new RegistrationViewForApi(email, password, name);

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }
}