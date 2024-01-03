import org.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class UserRegistrationTest {
    @Test
   public void testValidFirstName() {
        try {
            UserRegistration.validateFirstName("Megala");
        } catch (InvalidFirstNameException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }


    @Test
    public void testInvalidFirstName() {
        try {
            UserRegistration.validateFirstName("j");
            System.out.println("Expected InvalidFirstNameException, but no exception was thrown");
        } catch (InvalidFirstNameException exception) {
            System.out.println("Invalid First Name "+ exception.getMessage());
            Assert.assertEquals("Invalid First Name", exception.getMessage());
        }
    }

    @Test
    public void testValidLastName() {
        try {
            UserRegistration.validateLastName("Doe");
        } catch (InvalidLastNameException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLastName() {
        try {
            UserRegistration.validateLastName("d");
            System.out.println("Expected InvalidLastNameException, but no exception was thrown");
        } catch (InvalidLastNameException exception) {
            System.out.println(exception.getMessage());
            Assert.assertEquals("Invalid Last Name", exception.getMessage());
        }
    }

    @Test
    public void testValidEmail() {
        try {
            UserRegistration.validateEmail("abc.xyz@bl.co.in");
        } catch (InvalidEmailException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidEmail() {
        try {
            UserRegistration.validateEmail("invalid.email");
            System.out.println("Expected InvalidEmailException, but no exception was thrown");
        } catch (InvalidEmailException exception) {
            Assert.assertEquals("Invalid Email", exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testValidMobileNumber() {
        try {
            UserRegistration.validateMobileNumber("91 9919819801");
            System.out.println("Valid Mobile Number");
        } catch (InvalidMobileNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInvalidMobileNumber() {
        try {
            UserRegistration.validateMobileNumber("1234");
            System.out.println("Expected InvalidMobileNumberException, but no exception was thrown");

        } catch (InvalidMobileNumberException exception) {
            Assert.assertEquals("Invalid Mobile Number", exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testValidPassword() {
        try {
            UserRegistration.validatePassword("Pass@word1");
            System.out.println("Valid password");
        } catch (InvalidPasswordException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }

    @Test
    public void testInvalidPassword() {
        try {
            UserRegistration.validatePassword("password");
            System.out.println("Expected InvalidPasswordException, but no exception was thrown");
        } catch (InvalidPasswordException exception) {
            Assert.assertEquals("Invalid Password", exception.getMessage());
            System.out.println(exception.getMessage());
        }
    }


@ParameterizedTest
@ValueSource(strings = { "abc.xyz@bl.co.in", "def@gh.com", "ijk@lmn.opq" })
public void testParameterizedValidEmail(String email) {
    try {
        UserRegistration.validateEmail(email);
    } catch (InvalidEmailException e) {
        System.out.println(e.getMessage());
    }
}

    @ParameterizedTest
    @ValueSource(strings = { "invalid.email", "missing@dotcom", "noat" })
    public void testParameterizedInvalidEmail(String email) {
        try {
            UserRegistration.validateEmail(email);
            System.out.println("Expected InvalidEmailException, but no exception was thrown");

        } catch (InvalidEmailException exception) {
            System.out.println(exception.getMessage());
            Assert.assertEquals("Invalid Email", exception.getMessage());
        }
    }
}
