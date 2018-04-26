package by.rubakhin.epam.task1.validator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereValidator {
    private static Logger log = LogManager.getLogger("SphereValidator");

    public boolean isRadiusValid(double radius) {
        if (radius > 0) {
            return true;
        }
        log.warn("Radius must be greater than zero. Specified radius : " + radius);
        return false;
    }
}
