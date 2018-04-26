package test.by.rubakhin.epam.task1.entity;


import by.rubakhin.epam.task1.entities.Point;
import by.rubakhin.epam.task1.entities.Sphere;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SphereTest {
    Point point;

    @BeforeMethod
    public void setUp() throws Exception {
        point = new Point(1, 2, 3);
    }

    @Test
    public void testNewBuilder() throws Exception {
        Sphere sphere = new Sphere(point, 6);
        System.out.println(sphere.toString());
        assertEquals(sphere.getRadius(), 6, 0);
    }
}