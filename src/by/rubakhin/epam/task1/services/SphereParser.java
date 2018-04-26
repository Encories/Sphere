package by.rubakhin.epam.task1.services;
import by.rubakhin.epam.task1.exceptions.IncorrectUseOfParcerExcepcion;


public class SphereParser {

       public double[] arrayOfSphereFieldsParser(String s) throws IncorrectUseOfParcerExcepcion {
        final String SPLITTER = "\\s+";
        double[] d;
        String[] sMass;
        try {
            sMass = s.trim().split(SPLITTER);
            d = new double[sMass.length];
        } catch (IndexOutOfBoundsException e) {
            throw new IncorrectUseOfParcerExcepcion(e);
        }
        for (int i = 0; i < d.length; i++) {
            d[i] = Double.valueOf(sMass[i].replace(',', '.'));
        }
        return d;
    }


}
