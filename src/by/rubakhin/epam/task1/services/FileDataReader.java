package by.rubakhin.epam.task1.services;


import by.rubakhin.epam.task1.validator.FileValidator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileDataReader  {
    private static Logger log = LogManager.getLogger("FileDownloaderT");

    public List<String> readFromFile(File file) {
        FileValidator fileValidator = new FileValidator();
        List<String> list = new ArrayList<>();
        try {
            if (fileValidator.validateFile(file)) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    list.add(scanner.nextLine());
                }
                scanner.close();
            }

        } catch (FileNotFoundException e) {
            log.fatal("Incorrect file path!  " + e);
            throw new RuntimeException();
        }
        return list;
    }



    }








