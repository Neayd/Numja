package fr.uga.numja;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NdarrayTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosEmptyNdarray1D(){
        Ndarray.zeros(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosNdarray2DInvalidCols(){
        Ndarray.zeros(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosNdarray2DInvalidRows(){
        Ndarray.zeros(-1, 10);
    }

    @Test
    public void testCreateZerosNdarry1D(){
        Ndarray array = Ndarray.zeros(10);
        int[] shape = new int[2];
        shape[0] = 10;
        shape[1] = 0;
        assertEquals("Created array should have size", 10, array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
    }

    @Test
    public void testCreateZerosNdarry2D(){
        Ndarray array = Ndarray.zeros(10, 10);
        int[] shape = new int[2];
        shape[0] = 10;
        shape[1] = 10;
        assertEquals("Created array should have size", 100, array.getSize());
        assertEquals("Created array should have dimension ", 2, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
    }



}
