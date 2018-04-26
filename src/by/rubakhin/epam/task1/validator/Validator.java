package by.rubakhin.epam.task1.validator;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Validator {

    private static Logger log = LogManager.getLogger("Validator");

     public boolean isRadiusValid(double radius) {
        if (radius > 0) {
            return true;
        }
        log.warn("Radius must be greater than zero. Specified radius : " + radius);
        return false;
    }




}
