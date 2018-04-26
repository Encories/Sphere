package test.by.rubakhin.epam.task1.reader;


import by.rubakhin.epam.task1.services.FileDataReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;


public class DataFromFileReaderTest {
    static Logger logger = LogManager.getLogger(DataFromFileReaderTest.class);
    List<String> list;
    File file;

    @BeforeMethod
    public void setUp() throws Exception {
        list = new ArrayList<>();
        file = new File("files/INPUT.txt");
        if (!file.exists()) {
            file.createNewFile();
            Writer writer = new FileWriter(file);
            writer.write("123adsf.asdf 123 23 \n 2323 df df 13 \n324dsfg sdf3");
            writer.flush();
            writer.close();
        }
    }

    @Test
    public void testIsAnyCorrectStringThere() throws Exception {
        FileDataReader reader = new FileDataReader();
        list = reader.readFromFile(file);
        for (String s : list
                ) {
            logger.log(Level.INFO, s);
        }

        assertFalse(list.isEmpty());

    }


    @AfterMethod
    public void tearDown() throws Exception {
        logger.log(Level.INFO, file.delete());
    }
}