package test.by.rubakhin.epam.task1.validator;


import by.rubakhin.epam.task1.validator.FileValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileValidatorTest {
    File file;
    FileValidator fileValidator = new FileValidator();

    @Test
    public void testValidFile() throws Exception {
        assertTrue(fileValidator.validateFile(file));
    }



    @AfterMethod
    public void tearDown() throws Exception {
        file.delete();
    }
}