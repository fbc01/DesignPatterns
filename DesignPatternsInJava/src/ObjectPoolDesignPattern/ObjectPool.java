package ObjectPoolDesignPattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {

    //in-memory cache
    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count) {
        //thread-safe
        availablePool = new LinkedBlockingQueue<>();
        for (int i=0; i<count; i++) {
            availablePool.offer(creator.get()); //pre-creating objects
        }
    }

    public T get() {
        try {
            return availablePool.take();
        } catch (InterruptedException ex) {
            System.err.println("take() was interrupted");
        }
        return null;
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablePool.put(obj);
        } catch (InterruptedException ex) {
            System.err.println("put() was interrupted");
        }
    }
}
