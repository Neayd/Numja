package fr.uga.numja;

public class Ndarray {

    private int ndim;
    private int[] shape;
    private int size;
    private float[][] data;

    private Ndarray(){
        this.shape = new int[2];
    }

    //constructor for 1D array of zeros
    static public Ndarray zeros(int dim){
        return Ndarray.zeros(0, dim);
    }

    //constructor for 2D array of zeros
    static public Ndarray zeros(int rows, int cols){
        if(rows < 0 || cols <= 0){
            throw new IllegalArgumentException();
        }
        Ndarray array = new Ndarray();

        //set the attributes
        array.ndim = 1;
        //if we are in a 2D array
        if(rows > 0){
            array.ndim += 1;
        }
        array.shape[0] = cols;
        array.shape[1] = rows;
        array.size = cols;
        //if we are in a 2D array
        if(array.ndim == 2){
            array.size *= rows;
        }

        //init the array with zero

        //if we are in a 1D array
        if(array.ndim == 1){
            array.data = new float[1][cols];
            for (int i = 0; i < cols; i++) {
                array.data[0][i] = 0;
            }
        }

        //if we are in a 2D array
        if(array.ndim == 2) {
            array.data = new float[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    array.data[i][j] = 0;
                }
            }
        }

        return array;
    }

    static public Ndarray arange(float stop){
        return arange(0, stop, 1);
    }

    static public Ndarray arange(float start, float stop){
        return arange(start, stop, 1);
    }

    static public Ndarray arange(float start, float stop, float step){
        if((stop > start && step < 0) || (stop < start && step > 0) || step == 0){
            throw new IllegalArgumentException();
        }
        Ndarray array = new Ndarray();
        int nelem;

        array.ndim = 1;

        if (step > 0) {
            nelem = (int) Math.ceil((stop - start) / step);
        } else {
            nelem = (int) Math.ceil((start - stop) / (-step));
        }

        array.shape[0] = nelem;
        array.shape[1] = 0;
        array.size = nelem;

        array.data = new float[1][nelem];
        float val = start;
        for (int i = 0; i < nelem; i++) {
            array.data[0][i] = val;
            val += step;
        }

        return array;
    }



    public String toString(){
        StringBuilder string = new StringBuilder();
        int rows = shape[1];
        int cols = shape[0];

        //if we are in a 1D array
        if(ndim == 1){
            string.append("[");
            for (int i = 0; i < cols; i++) {
                string.append(data[0][i]);
                string.append(" ");
                if(i != cols - 1){
                    string.append(", ");
                }
            }
            string.append("]");
        }

        //if we are in a 2D array
        if(ndim == 2){
            string.append("[");
            for (int i = 0; i < rows; i++) {
                string.append("[");
                for (int j = 0; j < cols; j++) {
                    string.append(data[i][j]);
                    string.append(" ");
                    if(j != cols - 1){
                        string.append(", ");
                    }
                }
                string.append("]");
                if(i != rows - 1){
                    string.append(",\n");
                }
            }
            string.append("]");
        }
        return string.toString();
    }

    public int getNdim() {
        return ndim;
    }

    public int getSize() {
        return size;
    }

    public int[] getShape() {
        return shape.clone();
    }
}
