package by.rubakhin.epam.task1.actions;

import by.rubakhin.epam.task1.entities.CoordinatePlane;
import by.rubakhin.epam.task1.entities.Sphere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereAction  {
    private static Logger log = LogManager.getLogger("SphereAction");

    private SphereAction() {
    }

    public static SphereAction getInstance() {
        return SingletonHolder.SPHERE_ACTION;
    }

    public double sphereArea(Sphere sphere) {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public double sphereVolume(Sphere sphere) {
        return Math.PI * 3 * Math.pow(sphere.getRadius(), 3) / 4;
    }

    public boolean isThatASphere(Object sphere) {
        if (sphere != null && sphere.getClass() == Sphere.class) {
            return ((Sphere) sphere).getRadius() > 0;
        }
        return false;
    }

    public boolean isSphereTangentAxis(Sphere sphere) {
        double uncertainty = 0.00006;
        return Math.abs(Math.abs(sphere.getCenter().getxCoordinate()) - sphere.getRadius()) <= uncertainty
                || Math.abs(Math.abs(sphere.getCenter().getyCoordinate()) - sphere.getRadius()) <= uncertainty
                || Math.abs(Math.abs(sphere.getCenter().getzCoordinate()) - sphere.getRadius()) <= uncertainty;

    }

    public double ratioOfVolumesOfCutOffSpheresPart(Sphere sphere, CoordinatePlane c) {
        double volumeOfCutOffByAxisSphere = volumeOfCutOffByAxisSphere(sphere, c);
        return volumeOfCutOffByAxisSphere / (sphereVolume(sphere) - volumeOfCutOffByAxisSphere);
    }

    private double volumeOfCutOffByAxisSphere(Sphere sphere, CoordinatePlane c) {
        double h;
        switch (c) {
            case XOY:
                h = sphere.getRadius() - Math.abs(sphere.getCenter().getzCoordinate());
                break;
            case YOZ:
                h = sphere.getRadius() - Math.abs(sphere.getCenter().getxCoordinate());
                break;
            case XOZ:
                h = sphere.getRadius() - Math.abs(sphere.getCenter().getyCoordinate());
                break;
            default:
                h = 0;
        }
        if (h > 0) {
            return Math.PI * Math.pow(h, 2) * (sphere.getRadius() - h / 3);
        } else {
            return 0;
        }
    }

    private static class SingletonHolder {
        private final static SphereAction SPHERE_ACTION = new SphereAction();
    }





}