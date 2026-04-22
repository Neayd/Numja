package fr.uga.numja;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {

        // --- Creation ---

        System.out.println("=== Creation ===\n");

        System.out.println("1D array from values:");
        System.out.println("Ndarray.array(new float[]{1, 2, 3, 4, 5})");
        Ndarray a1d = Ndarray.array(new float[]{1, 2, 3, 4, 5});
        System.out.println(a1d + "\n");

        System.out.println("2D array from values:");
        System.out.println("Ndarray.array(new float[][]{{1,2,3},{4,5,6}})");
        Ndarray a2d = Ndarray.array(new float[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(a2d + "\n");

        System.out.println("1D zeros:");
        System.out.println("Ndarray.zeros(5)");
        System.out.println(Ndarray.zeros(5) + "\n");

        System.out.println("2D zeros:");
        System.out.println("Ndarray.zeros(2, 4)");
        System.out.println(Ndarray.zeros(2, 4) + "\n");

        System.out.println("arange(stop):");
        System.out.println("Ndarray.arange(5)");
        System.out.println(Ndarray.arange(5) + "\n");

        System.out.println("arange(start, stop):");
        System.out.println("Ndarray.arange(2, 7)");
        System.out.println(Ndarray.arange(2, 7) + "\n");

        System.out.println("arange(start, stop, step):");
        System.out.println("Ndarray.arange(0, 1, 0.25f)");
        System.out.println(Ndarray.arange(0, 1, 0.25f) + "\n");

        // --- Attributes ---

        System.out.println("=== Attributes ===\n");

        Ndarray attr = Ndarray.array(new float[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println("Array: " + attr);
        System.out.println("attr.getNdim()  -> " + attr.getNdim());
        System.out.println("attr.getShape() -> " + Arrays.toString(attr.getShape()));
        System.out.println("attr.getSize()  -> " + attr.getSize() + "\n");

        // --- Element access ---

        System.out.println("=== Element access ===\n");

        Ndarray v = Ndarray.arange(1, 6);
        System.out.println("1D array: " + v);
        System.out.println("v.get(2)      -> " + v.get(2));
        System.out.println("v.set(99, 2)  -> ");
        v.set(99, 2);
        System.out.println(v + "\n");

        Ndarray m = Ndarray.array(new float[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println("2D array: " + m);
        System.out.println("m.get(1, 2)        -> " + m.get(1, 2));
        System.out.println("m.getArray(0)      -> " + Arrays.toString(m.getArray(0)));
        System.out.println("m.set(99, 1, 2)    -> ");
        m.set(99, 1, 2);
        System.out.println(m + "\n");

        // --- Reshape ---

        System.out.println("=== Reshape ===\n");

        Ndarray r = Ndarray.arange(1, 7);
        System.out.println("1D array: " + r);
        System.out.println("r.reshape(2, 3)  -> ");
        r.reshape(2, 3);
        System.out.println(r + "\n");

        System.out.println("2D array: " + r);
        System.out.println("r.reshape(6, 0) (back to 1D)  -> ");
        r.reshape(6, 0);
        System.out.println(r + "\n");

        // --- Addition ---

        System.out.println("=== Addition ===\n");

        Ndarray x = Ndarray.array(new float[]{1, 2, 3});
        System.out.println("Array: " + x);
        System.out.println("x.add(10)  -> " + x.add(10));
        System.out.println("x unchanged: " + x + "\n");

        System.out.println("x.addEquals(10)  -> ");
        x.addEquals(10);
        System.out.println(x + "\n");

        Ndarray y = Ndarray.array(new float[]{10, 20, 30});
        System.out.println("x=" + x + "  y=" + y);
        System.out.println("x.add(y)  -> " + x.add(y));
        System.out.println("x unchanged: " + x + "\n");

        System.out.println("x.addEquals(y)  -> ");
        x.addEquals(y);
        System.out.println(x + "\n");
    }
}
