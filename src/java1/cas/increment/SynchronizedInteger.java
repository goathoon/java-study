package java1.cas.increment;

public class SynchronizedInteger implements IncrementInteger{

    private int value;

    @Override
    synchronized public void increment() {
        value++;
    }

    @Override
    synchronized public int get() {
        return value;
    }
}
