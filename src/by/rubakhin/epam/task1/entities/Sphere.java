package by.rubakhin.epam.task1.entities;

import by.rubakhin.epam.task1.exceptions.IncorrectArrayToBuildSphereException;
import by.rubakhin.epam.task1.exceptions.IncorrectRadiusOfSphereException;
import by.rubakhin.epam.task1.observe.Observer;
import by.rubakhin.epam.task1.validator.Validator;

import java.util.ArrayList;
import java.util.Iterator;

public class Sphere {
    static Validator validator = new Validator();
    private double radius;
    private Point center;

    private ArrayList<Observer> observerList = new ArrayList<>();
    public void addObserver(Observer observer) {
        observerList.add(observer);
        observer.handleEvent(this);
    }

    public Sphere(Point point, double radius) throws IncorrectRadiusOfSphereException {
        setRadius(radius);
        this.center = point;
    }

    public Sphere(double[] pointAndRadius) throws IncorrectArrayToBuildSphereException, IncorrectRadiusOfSphereException {
        if (pointAndRadius.length != 4) {
            throw new IncorrectArrayToBuildSphereException("Length of array to build a Sphere must be 4");
        }
        setCenter(new Point(pointAndRadius[0], pointAndRadius[1], pointAndRadius[2]));
        setRadius(pointAndRadius[3]);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IncorrectRadiusOfSphereException {
        if (validator.isRadiusValid(radius)) {
            this.radius = radius;
        } else {
            throw new IncorrectRadiusOfSphereException();
        }
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    private void notifyObservers() {
        Iterator it = observerList.iterator();
        while (it.hasNext()) {
            ((Observer) it.next()).handleEvent(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sphere sphere = (Sphere) o;

        if (Double.compare(sphere.radius, radius) != 0) return false;
        return center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + center.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}




