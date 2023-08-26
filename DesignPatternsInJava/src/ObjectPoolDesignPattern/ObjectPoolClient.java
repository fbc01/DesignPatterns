package ObjectPoolDesignPattern;

import java.awt.Point;

public class ObjectPoolClient {

    public static final ObjectPool<BitmapImage> bitmapPool =
            new ObjectPool<>(()->new BitmapImage("logo.png"), 5);

    public static void getObjectPoolImplementation() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(5, 15);
        BitmapImage b1 = bitmapPool.get();
        BitmapImage b2 = bitmapPool.get();
        b1.setLocation(p1);
        b2.setLocation(p2);
        b1.draw();
        b2.draw();
        bitmapPool.release(b1);
        bitmapPool.release(b2);
    }
}
