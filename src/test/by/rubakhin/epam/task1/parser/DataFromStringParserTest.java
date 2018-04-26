package test.by.rubakhin.epam.task1.parser;


import by.rubakhin.epam.task1.services.SphereParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataFromStringParserTest {
    SphereParser parser = new SphereParser();

    @Test
    public void testArrayOfSphereFieldsParser() throws Exception {
        String stringToParse = "   1,2  2  3      4.2";
        double[] excepted = {1.2, 2, 3, 4.2};
        assertEquals(parser.arrayOfSphereFieldsParser(stringToParse), excepted);
    }

}