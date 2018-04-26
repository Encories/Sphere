package test.by.rubakhin.epam.task1.validator;


import by.rubakhin.epam.task1.validator.StringValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class StringValidatorTest {
    @Test
    public void testValidateString() throws Exception {
        StringValidator validator = new StringValidator();
        String s = "2,3 23 3,15 2";
        assertTrue(validator.validateStringAsSphereFields(s));
    }

}