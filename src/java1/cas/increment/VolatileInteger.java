package java1.cas.increment;

public class VolatileInteger implements IncrementInteger{
    volatile private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
