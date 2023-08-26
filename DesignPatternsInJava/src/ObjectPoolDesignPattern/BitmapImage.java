package ObjectPoolDesignPattern;

import java.awt.geom.Point2D;

public class BitmapImage implements Image {

    private Point2D location;
    private String name;

    public BitmapImage(String name) {
        this.name = name;
    }
    @Override
    public void draw() {
        System.out.println("Drawing name = " + this.name + "  location = " + this.location);
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public void reset() {
        this.location = null;
        System.out.println("Bitmap was reset");
    }
}
