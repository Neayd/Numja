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

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArangeNdarrayInvalidStart(){
        Ndarray.arange(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArangeNdarrayInvalidSartStop(){
        Ndarray.arange(5 , 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArangeNdarrayInvalidSartStopWithStep(){
        Ndarray.arange(10 , 0, 0.02F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArangeNdarrayInvalidSartStopWithNegStep(){
        Ndarray.arange(0 , 10, -0.02F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArangeNdarrayInvalidStep(){
        Ndarray.arange(0 , 10, 0);
    }

    @Test
    public void testCreateArangeNdarryStart(){
        Ndarray array = Ndarray.arange(3);
        int[] shape = new int[2];
        shape[0] = 3;
        shape[1] = 0;
        assertEquals("Created array should have size", 3, array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 2", "[0.0 , 1.0 , 2.0 ]", array.toString());
    }

    @Test
    public void testCreateArangeNdarryStartStop(){
        Ndarray array = Ndarray.arange(1, 3);
        int[] shape = new int[2];
        shape[0] = 2;
        shape[1] = 0;
        assertEquals("Created array should have size", 2, array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 2", "[1.0 , 2.0 ]", array.toString());
    }

    @Test
    public void testCreateArangeNdarryStartStopStep(){
        Ndarray array = Ndarray.arange(1, 3, 0.5F);
        int[] shape = new int[2];
        shape[0] = 4;
        shape[1] = 0;
        assertEquals("Created array should have size", 4, array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 2", "[1.0 , 1.5 , 2.0 , 2.5 ]", array.toString());
    }

    @Test
    public void testCreateArangeNdarryStartStopNegStep(){
        Ndarray array = Ndarray.arange(3, 1, -0.5F);
        int[] shape = new int[2];
        shape[0] = 4;
        shape[1] = 0;
        assertEquals("Created array should have size", 4, array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 2", "[3.0 , 2.5 , 2.0 , 1.5 ]", array.toString());
    }

    @Test
    public void testToStringZerosNdarray1D(){
        Ndarray array = Ndarray.zeros(10);
        assertEquals("Array should have 10 zeros", "[0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 ]", array.toString());
    }

    @Test
    public void testToStringZerosNdarray2D(){
        Ndarray array = Ndarray.zeros(2,5);
        assertEquals("Array should have 2 times 5 zeros", "[[0.0 , 0.0 , 0.0 , 0.0 , 0.0 ],\n[0.0 , 0.0 , 0.0 , 0.0 , 0.0 ]]", array.toString());
    }

}
