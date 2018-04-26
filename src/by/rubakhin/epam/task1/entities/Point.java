package by.rubakhin.epam.task1.entities;

public class Point {


    private  double xCoordinate;
    private  double yCoordinate;
    private  double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getzCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare( point.xCoordinate, xCoordinate ) != 0) return false;
        if (Double.compare( point.yCoordinate, yCoordinate ) != 0) return false;
        return Double.compare( point.zCoordinate, zCoordinate ) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits( xCoordinate );
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( yCoordinate );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits( zCoordinate );
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", zCoordinate=" + zCoordinate +
                '}';
    }
}
