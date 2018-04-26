package by.rubakhin.epam.task1.observe;


import by.rubakhin.epam.task1.entities.Sphere;

public class SphereVolume implements Observer  {

    private double volume;
    @Override
    public void handleEvent(Sphere sphere) {
        volume = calculateSphereVolume(sphere);

    }


    public static double calculateSphereVolume(Sphere sphere) {

        return Math.PI * 3 * Math.pow(sphere.getRadius(), 3) / 4;
    }


    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SphereVolume that = (SphereVolume) o;

        return Double.compare( that.volume, volume ) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits( volume );
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "SphereVolume{" +
                "volume=" + volume +
                '}';
    }
}



