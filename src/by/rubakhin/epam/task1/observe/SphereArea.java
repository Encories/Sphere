package by.rubakhin.epam.task1.observe;


import by.rubakhin.epam.task1.entities.Sphere;

public class SphereArea implements Observer {
    private double area;

    @Override
    public void handleEvent(Sphere sphere) {
        area = calculateSphereArea(sphere);
    }

    public double calculateSphereArea(Sphere sphere) {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphereArea that = (SphereArea) o;

        return Double.compare( that.area, area ) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits( area );
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "SphereArea{" +
                "area=" + area +
                '}';
    }
}
