package test.by.rubakhin.epam.task1.creator;


import by.rubakhin.epam.task1.creator.EntityCreator;
import by.rubakhin.epam.task1.entities.Sphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SphereCreatorTest {
    static final Logger LOGGER = LogManager.getLogger(SphereCreatorTest.class);
    File file;

    @BeforeMethod
    public void setUp() throws Exception {
        File folder = new File("./resource");
        if (!folder.exists()) {
            folder.mkdir();
        }
        file = new File(folder.getPath() + "/test.txt");
        if (!file.exists()) {
            file.createNewFile();
            Writer writer = new FileWriter(file);
            writer.write("1123. sa\n" +
                    "asdf3fg fwsd\n" +
                    "fsdf312r esf\n" +
                    "f 3fs33 v\n" +
                    "1.2 3,4 3,3     2.233\n" +
                    "       1.2 3,4 3,3     2.233 3\n" +
                    " 1. 2 34 5 \n" +
                    " 1 2 3 4");
            writer.flush();
            writer.close();
        }
    }

    @Test
    public void testCreateBallsFromFile() throws Exception {
        EntityCreator sphereCreator = EntityCreator.getInstance();
        List<Sphere> list;
        list = sphereCreator.createSpheresFromFile(file);
        for (Sphere b : list
                ) {
            LOGGER.log(Level.INFO, b);
        }

        assertEquals(list.get(0).getClass(), Sphere.class);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        LOGGER.log(Level.INFO, file.delete());
    }

}