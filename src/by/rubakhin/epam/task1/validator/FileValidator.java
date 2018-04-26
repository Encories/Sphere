package by.rubakhin.epam.task1.validator;

import java.io.File;

public class FileValidator {
    public boolean validateFile(File file) {
        return file != null && file.exists() && file.canRead();
    }
}
