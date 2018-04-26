package by.rubakhin.epam.task1.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    private static Logger log = LogManager.getLogger("StringValidator");

    public boolean validateStringAsSphereFields(String s) {
        final Pattern IS_DOUBLES_HERE = Pattern.compile("((\\s+)?[-]?[\\d]+(.[\\d]+)?(\\s+)?){4}");
        final String SPLITTER = "\\s+";
        Matcher m = IS_DOUBLES_HERE.matcher(s);
        final int countOfDoublesInSphereFields = 4;
        if (m.matches()) {
            String[] sMass = s.trim().split(SPLITTER);
            return sMass.length == countOfDoublesInSphereFields;
        } else {
            log.warn("Input string {" + s + "} is incorrect");
            return false;
        }
    }

}
