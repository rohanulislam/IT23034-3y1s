package validation.service;

import validation.exceptions.InvalidAgeException;
import validation.exceptions.InvalidDeptException;

public class Validator {

    public static void validate(int age, String dept)
            throws InvalidAgeException, InvalidDeptException {

        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60");
        }

        if (!(dept.equals("CSE") || dept.equals("EEE") || dept.equals("BBA"))) {
            throw new InvalidDeptException("Invalid Department");
        }

        System.out.println("Validation Successful");
    }
}
