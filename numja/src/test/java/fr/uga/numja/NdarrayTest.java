package fr.uga.numja;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NdarrayTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArrayNull1D(){
        Ndarray.array((float[]) null);
    }

    @Test
    public void testCreateArray1D(){
        float[] tab = {0, 1, 2, 3, 4};
        Ndarray array = Ndarray.array(tab);
        int[] shape = new int[2];
        shape[0] = 5;
        shape[1] = 0;
        assertEquals("Created array should have size ", 5,array.getSize());
        assertEquals("Created array should have dimension ", 1, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 4", "[0.0 , 1.0 , 2.0 , 3.0 , 4.0 ]", array.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateArrayNull2D(){
        Ndarray.array((float[][]) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArrayNullInArray2D(){
        float[][] tab = {null};
        Ndarray.array(tab);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArraySubArrayNotSameSize2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2};
        float[][] tab = {subtab1,subtab2};
        Ndarray.array(tab);
    }

    @Test
    public void testCreateArray2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        int[] shape = new int[2];
        shape[0] = 2;
        shape[1] = 2;
        assertEquals("Created array should have size ", 4,array.getSize());
        assertEquals("Created array should have dimension ", 2, array.getNdim());
        assertArrayEquals("Created array should have the shape", shape, array.getShape());
        assertEquals("Array should have 0 to 4", "[[0.0 , 1.0 ],\n[2.0 , 3.0 ]]", array.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosEmptyNdarray1D(){
        Ndarray.zeros(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosNdarray2DInvalidCols(){
        Ndarray.zeros(1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateZerosNdarray2DInvalidRows(){
        Ndarray.zeros(0, 10);
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
        Ndarray array = Ndarray.zeros(2, 10);
        int[] shape = new int[2];
        shape[0] = 2;
        shape[1] = 10;
        assertEquals("Created array should have size", 20, array.getSize());
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

    @Test(expected = UnsupportedOperationException.class)
    public void testGet1DOn2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet1DNegIndex(){
        Ndarray array = Ndarray.arange(3);
        array.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet1DHighIndex(){
        Ndarray array = Ndarray.arange(3);
        array.get(3);
    }

    @Test
    public void testGet1D(){
        Ndarray array = Ndarray.arange(3);
        assertEquals("Get element should be ",1, array.get(1), 1e-6f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGet2DOn1D(){
        Ndarray array = Ndarray.arange(3);
        array.get(0,0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet2DNegFirstIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.get(-1,0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet2DNegSecIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.get(0,-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet2DHighFirstIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.get(3,0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet2DHighSecIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.get(0,3);
    }

    @Test
    public void testGet2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        assertEquals("Get element should be ", 3, array.get(1,1), 1e-6f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetArrayOn1D(){
        Ndarray array = Ndarray.arange(3);
        array.getArray(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetArrayNegIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.getArray(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetArrayHighIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.getArray(3);
    }

    @Test
    public void testGetArray(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        assertArrayEquals("Array should be the same ", subtab1, array.getArray(0), 1e-6f);
        assertArrayEquals("Array should be the same ", subtab2, array.getArray(1), 1e-6f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSet1DOn2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set(0,0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet1DNegIndex(){
        Ndarray array = Ndarray.arange(3);
        array.set( 2, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet1DHighIndex(){
        Ndarray array = Ndarray.arange(3);
        array.set( 2, 3);
    }

    @Test
    public void testSet1D(){
        Ndarray array = Ndarray.arange(3);
        array.set( 2, 0);
        assertEquals("Get element should be ", 2, array.get(0), 1e-6f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSet2DOn1D(){
        Ndarray array = Ndarray.arange(3);
        array.set( 1, 0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet2DNegFirstIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set( 0, -1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet2DNegSecIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set( 0, 0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet2DHighFirstIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set( 0, 3, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet2DHighSecIndex(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set(0, 0, 3);
    }

    @Test
    public void testSet2D(){
        float[] subtab1 = {0,1};
        float[] subtab2 = {2,3};
        float[][] tab = {subtab1,subtab2};
        Ndarray array = Ndarray.array(tab);
        array.set(0, 1, 1);
        assertEquals("Get element should be ", 0, array.get(1,1), 1e-6f);
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
