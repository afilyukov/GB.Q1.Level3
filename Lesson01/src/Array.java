import java.util.Arrays;

public class Array<E> {
    private final Object[] obj_array;
    public final int length;

    public Array(int length)    {
        obj_array = new Object [length];
        this.length = length;
    }

    E get(int i) {
        final E e = (E)obj_array[i];
        return e;
    }

    void set(int i, E e) {
        obj_array[i] = e;
    }

    @Override
    public String toString() {
        return Arrays.toString(obj_array);
    }
}