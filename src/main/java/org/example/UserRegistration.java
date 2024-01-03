package org.example;

public class UserRegistration {
    public static void validateFirstName(String firstName) throws InvalidFirstNameException {
        if (!firstName.matches("[A-Z]{1}[a-zA-Z]{2,}")) {
            throw new InvalidFirstNameException("Invalid First Name");
        }
    }

    public static void validateLastName(String lastName) throws InvalidLastNameException {
        if (!lastName.matches("[A-Z]{1}[a-zA-Z]{2,}")) {
            throw new InvalidLastNameException("Invalid Last Name");
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.matches("[a-zA-Z]+(\\w)*((\\-|\\+|\\.)\\w+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})?(\\.[a-zA-Z]{2,})")) {
            throw new InvalidEmailException("Invalid Email");
        }
    }

    public static void validateMobileNumber(String mobileNumber) throws InvalidMobileNumberException {
        if (!mobileNumber.matches("(91){1}\\s+[6-9][0-9]{9}")) {
            throw new InvalidMobileNumberException("Invalid Mobile Number");
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if(!password.matches(".*[A-Z].*") || !hasMinimumLength(password) || !password.matches(".*\\d.*") || !password.matches(".*\\W.*")){
            throw new InvalidPasswordException("Invalid Password");
        }
    }
    private static boolean hasMinimumLength(String password) {
        return password.length() >= 8;
    }

}
