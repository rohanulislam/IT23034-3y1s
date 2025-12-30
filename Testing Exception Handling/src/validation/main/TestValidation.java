package validation.main;

import validation.exceptions.InvalidAgeException;
import validation.exceptions.InvalidDeptException;
import validation.service.Validator;

public class TestValidation {

    public static void main(String[] args) {

        try {
            Validator.validate(17, "CSE");
            Validator.validate(25, "ME");
        }
        catch (InvalidAgeException e) {
            System.out.println("Age Error: " + e.getMessage());
        }
        catch (InvalidDeptException e) {
            System.out.println("Dept Error: " + e.getMessage());
        }
        finally {
            System.out.println("Validation Test Completed");
        }
    }
}
