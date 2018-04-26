package test.by.rubakhin.epam.task1.actions;


import by.rubakhin.epam.task1.actions.SphereAction;
import by.rubakhin.epam.task1.entities.CoordinatePlane;
import by.rubakhin.epam.task1.entities.Sphere;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class SphereActionTest {
    static Logger logger = LogManager.getLogger(SphereActionTest.class);
    SphereAction action = SphereAction.getInstance();
    double volume;
    double radius = 1;
    Sphere sphere;

    @Test
    public void testSphereArea() throws Exception {
        volume = 4 * Math.PI * radius;
        double[] fields = {1, 1, 1, 1};
        sphere = new Sphere(fields);
        assertEquals(action.sphereArea(sphere), volume, 0.001);
    }

    @Test
    public void testSphereVolume() throws Exception {
        volume = Math.PI * 3 * Math.pow(radius, 3) / 4;
        double[] fields = {1, 1, 1, radius};
        sphere = new Sphere(fields);
        assertEquals(action.sphereVolume(sphere), volume, 0.001);
    }

    @Test
    public void testIsThatASphere() throws Exception {
        assertFalse(action.isThatASphere(null));
    }

    @Test
    public void testIsSphereTangentAxis() throws Exception {
        double[] fields = {5, 5, 5, 3};
        sphere = new Sphere(fields);
        assertFalse(action.isSphereTangentAxis(sphere));
    }

    @Test
    public void testCuttedSphereVolumeRatio() throws Exception {
        double[] fields = {4, 5, 5, 8};
        sphere = new Sphere(fields);
        double expected = 0.3846;
        logger.log(Level.INFO, action.ratioOfVolumesOfCutOffSpheresPart(sphere, CoordinatePlane.YOZ));
        assertEquals(action.ratioOfVolumesOfCutOffSpheresPart(sphere, CoordinatePlane.YOZ), expected, 0.001);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        volume = 0;
        sphere = null;
    }
}