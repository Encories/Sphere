package by.rubakhin.epam.task1.creator;

import by.rubakhin.epam.task1.entities.CoordinatePlane;
import by.rubakhin.epam.task1.exceptions.*;
import by.rubakhin.epam.task1.entities.Sphere;
import by.rubakhin.epam.task1.observe.SphereVolume;
import by.rubakhin.epam.task1.services.SphereParser;
import by.rubakhin.epam.task1.services.FileDataReader;

import by.rubakhin.epam.task1.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EntityCreator {


        private static Logger log = LogManager.getLogger("EntityCreator");

    private EntityCreator() {
    }

    public static EntityCreator getInstance() {
        return SingletonHolder.ENTITY_CREATOR;
    }

    public double ratioOfVolumesOfCutOffSpheresPart(Sphere sphere, CoordinatePlane c) {
        double volumeOfCutOffByAxisSphere = volumeOfCutOffByAxisSphere(sphere, c);
        return volumeOfCutOffByAxisSphere / (SphereVolume.calculateSphereVolume(sphere) - volumeOfCutOffByAxisSphere);
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

    public List<Sphere> createSpheresFromFile(File file) throws IncorrectUseOfParcerExcepcion, SphereException, IncorrectArrayToBuildSphereException, IncorrectRadiusOfSphereException {
        double[] fields;
        List<Sphere> sphereList = new ArrayList<Sphere>();
        StringValidator stringValidator = new StringValidator();
        FileDataReader reader = new FileDataReader();
        SphereParser parser = new SphereParser();

        List<String> list = reader.readFromFile(file);
        for (String s : list
                ) {
            if (stringValidator.validateStringAsSphereFields(s)) {
                fields = parser.arrayOfSphereFieldsParser(s);
                sphereList.add(new Sphere(fields));
            }
        }
        if (list.isEmpty()) {
            throw new SphereException ("There aren't any objects like Sphere in this file: " + file.getAbsolutePath());
        }
        return sphereList;
    }

    private static class SingletonHolder {
        private final static EntityCreator ENTITY_CREATOR = new EntityCreator();
    }



}


