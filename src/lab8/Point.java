package lab8;

import java.awt.geom.Point2D;
import java.util.Objects;

public class Point {
    double x,y;

    public static void main(String[] args) {
        Point point=new Point(1,1);
        Point point2=new Point(1,2);
        Point point3=new Point(1,1);
        System.out.println("point.equals(point2)");
        System.out.println(point.equals(point2));
        System.out.println("point.equals(point3)");
        System.out.println(point.equals(point3));

//        point.equals(point2)
//        false
//        point.equals(point3)
//        true
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }

    public int hashCode() {
        long bits = java.lang.Double.doubleToLongBits(getX());
        bits ^= java.lang.Double.doubleToLongBits(getY()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }
}
