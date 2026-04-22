package fr.uga.numja;

public class Ndarray {

    private int ndim;
    private int[] shape;
    private int size;
    private float[][] data;

    private Ndarray(){
        this.shape = new int[2];
    }

    /**
     * Creates a 1D Ndarray from a float array.
     *
     * @param tab input array
     *
     * @return a 1D Ndarray containing the same values
     */
    static public Ndarray array(float[] tab){
        if(tab == null){
            throw new IllegalArgumentException();
        }
        Ndarray array = new Ndarray();
        array.ndim = 1;
        array.shape[0] = tab.length;
        array.shape[1] = 0;
        array.size = array.shape[0];

        array.data = new float[1][array.shape[0]];
        System.arraycopy(tab, 0, array.data[0], 0, tab.length);

        return array;
    }

    /**
     * Creates a 2D Ndarray from a 2D float array.
     *
     * @param tab input 2D array
     *
     * @return a 2D Ndarray containing the same values
     */
    static public Ndarray array(float[][] tab){
        if(tab == null){
            throw new IllegalArgumentException();
        }

        //check if all rows have the same length
        try{
            int len = tab[0].length;
            for(int i = 1; i < tab.length; i++){
                if(tab[i].length != len){
                    throw new IllegalArgumentException("All rows must have the same length");
                }
            }
        }catch (NullPointerException e){
            throw new IllegalArgumentException();
        }

        Ndarray array = new Ndarray();
        array.ndim = 2;
        array.shape[0] = tab.length;
        array.shape[1] = tab[0].length;
        array.size = array.shape[0] * array.shape[1];

        array.data = new float[array.shape[0]][array.shape[1]];
        for(int i = 0; i < array.shape[0]; i++){
            System.arraycopy(tab[i], 0, array.data[i], 0, array.shape[1]);
        }

        return array;
    }

    /**
     * Creates a 1D array filled with zeros.
     *
     * @param dim size of the array
     *
     * @return a 1D Ndarray of length dim
     */
    static public Ndarray zeros(int dim){
        return Ndarray.zeros(dim, 0);
    }

    /**
     * Creates a 2D array filled with zeros.
     *
     * @param rows number of rows
     * @param cols number of columns
     *
     * @return a 2D Ndarray of shape (rows, cols)
     */
    static public Ndarray zeros(int rows, int cols){
        if(rows <= 0 || cols < 0){
            throw new IllegalArgumentException();
        }
        Ndarray array = new Ndarray();

        //set the attributes
        array.ndim = 1;
        //if we are in a 2D array
        if(cols > 0){
            array.ndim += 1;
        }
        array.shape[0] = rows;
        array.shape[1] = cols;
        array.size = rows;
        //if we are in a 2D array
        if(array.ndim == 2){
            array.size *= cols;
        }

        //init the array with zero

        //if we are in a 1D array
        if(array.ndim == 1){
            array.data = new float[1][rows];
            for (int i = 0; i < rows; i++) {
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

    /**
     * Creates a 1D array with values from 0 to stop-1 with a step of 1.
     *
     * @param stop end value (excluded)
     *
     * @return a 1D Ndarray
     */
    static public Ndarray arange(float stop){
        return arange(0, stop, 1);
    }

    /**
     * Creates a 1D array with values from start to stop-1 with a step of 1.
     *
     * @param start starting value
     * @param stop ending value (excluded)
     *
     * @return a 1D Ndarray
     */
    static public Ndarray arange(float start, float stop){
        return arange(start, stop, 1);
    }

    /**
     * Creates a 1D array with values from start to stop-1 with a given step.
     *
     * @param start starting value
     * @param stop ending value (excluded)
     * @param step step between values
     *
     * @return a 1D Ndarray
     */
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

    /**
     * Reshapes the current array to the given dimensions.
     *
     * @param firstDim  size of the first dimension
     * @param secondDim size of the second dimension (use 0 for 1D reshape).
     */
    public void reshape(int firstDim, int secondDim){
        if(firstDim <= 0 || secondDim < 0){
            throw new IllegalArgumentException();
        }

        //reshape 1D
        if(secondDim == 0){
            reshape1D( firstDim, secondDim);
        }else{//reshape 2D
            reshape2D( firstDim, secondDim);
        }
    }

    private void reshape1D(int firstDim, int secondDim){
        if(firstDim != size){
            throw new IllegalArgumentException("Incompatible reshape");
        }

        if(ndim == 2){
            float[] array = new float[size];
            int k = 0;

            for(int i = 0; i < shape[0]; i++){
                for(int j = 0; j < shape[1]; j++){
                    array[k++] = data[i][j];
                }
            }

            data = new float[1][size];
            System.arraycopy(array, 0, data[0], 0, size);

            ndim = 1;
            shape[0] = size;
            shape[1] = 0;
        }
    }

    private void reshape2D(int firstDim, int secondDim){
        if(firstDim * secondDim != size){
            throw new IllegalArgumentException("Incompatible reshape");
        }

        float[] array = new float[size];
        int k = 0;

        //copy data to a flat array
        if(ndim == 1){
            System.arraycopy(data[0], 0, array, 0, size);
        } else {
            for(int i = 0; i < shape[0]; i++){
                for(int j = 0; j < shape[1]; j++){
                    array[k++] = data[i][j];
                }
            }
        }

        // rebuild 2D
        float[][] newData = new float[firstDim][secondDim];
        k = 0;
        for(int i = 0; i < firstDim; i++){
            for(int j = 0; j < secondDim; j++){
                newData[i][j] = array[k++];
            }
        }

        data = newData;
        ndim = 2;
        shape[0] = firstDim;
        shape[1] = secondDim;
    }

    /**
     * Gets an element from a 1D array.
     *
     * @param index position
     *
     * @return value at index
     */
    public float get(int index){
        if(ndim != 1){
            throw new UnsupportedOperationException("Only available for 1D array");
        }

        if(index < 0 || index >= shape[0]){
            throw new IndexOutOfBoundsException();
        }

        return data[0][index];
    }

    /**
     * Gets an element from a 2D array.
     *
     * @param firstIndex row index
     * @param secondIndex column index
     *
     * @return value at position (row, col)
     */
    public float get(int firstIndex, int secondIndex){
        if(ndim != 2){
            throw new UnsupportedOperationException("Only available for 2D array");
        }

        if(firstIndex < 0 || firstIndex >= shape[0] || secondIndex < 0 || secondIndex >= shape[1]){
            throw new IndexOutOfBoundsException();
        }

        return data[firstIndex][secondIndex];
    }

    /**
     * Returns a copy of a row from a 2D array.
     *
     * @param index row index
     *
     * @return a copy of the row
     */
    public float[] getArray(int index){
        if(ndim != 2){
            throw new UnsupportedOperationException("Only available for 2D array");
        }

        if(index < 0 || index >= shape[0]){
            throw new IndexOutOfBoundsException();
        }

        return data[index].clone();
    }

    /**
     * Sets a value in a 1D array.
     *
     * @param value value to set
     * @param index position
     */
    public void set(float value, int index){
        if(ndim != 1){
            throw new UnsupportedOperationException("Only available for 1D array");
        }

        if(index < 0 || index >= shape[0]){
            throw new IndexOutOfBoundsException();
        }

        data[0][index] = value;
    }

    /**
     * Sets a value in a 2D array.
     *
     * @param value value to set
     * @param firstIndex row index
     * @param secondIndex column index
     */
    public void set(float value, int firstIndex, int secondIndex){
        if(ndim != 2){
            throw new UnsupportedOperationException("Only available for 2D array");
        }

        if(firstIndex < 0 || firstIndex >= shape[0] || secondIndex < 0 || secondIndex >= shape[1]){
            throw new IndexOutOfBoundsException();
        }

        data[firstIndex][secondIndex] = value;
    }

    /**
     * Returns a string representation of the array.
     *
     * @return formatted string of array values
     */
    public String toString(){
        StringBuilder string = new StringBuilder();

        //if we are in a 1D array
        if(ndim == 1){
            int size = shape[0];
            string.append("[");
            for (int i = 0; i < size; i++) {
                string.append(data[0][i]);
                string.append(" ");
                if(i != size - 1){
                    string.append(", ");
                }
            }
            string.append("]");
        }

        //if we are in a 2D array
        if(ndim == 2){
            int rows = shape[0];
            int cols = shape[1];
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

    /** @return number of dimensions */
    public int getNdim() {
        return ndim;
    }

    /** @return total number of elements */
    public int getSize() {
        return size;
    }

    /** @return shape of the array */
    public int[] getShape() {
        return shape.clone();
    }

    /**
     * Returns a new Ndarray with value added to each element.
     *
     * @param value scalar to add
     *
     * @return new Ndarray
     */
    public Ndarray add(float value) {
        Ndarray result = new Ndarray();
        result.ndim = this.ndim;
        result.shape = this.shape.clone();
        result.size = this.size;
        result.data = new float[this.data.length][];
        for (int i = 0; i < this.data.length; i++) {
            result.data[i] = this.data[i].clone();
            for (int j = 0; j < result.data[i].length; j++) {
                result.data[i][j] += value;
            }
        }
        return result;
    }

    /**
     * Returns a new Ndarray with element-wise addition of another Ndarray.
     * Shapes must match.
     *
     * @param other Ndarray to add
     *
     * @return new Ndarray
     */
    public Ndarray add(Ndarray other) {
        if (other == null || this.ndim != other.ndim
                || this.shape[0] != other.shape[0]
                || this.shape[1] != other.shape[1]) {
            throw new IllegalArgumentException("Shapes must match for element-wise addition");
        }
        Ndarray result = new Ndarray();
        result.ndim = this.ndim;
        result.shape = this.shape.clone();
        result.size = this.size;
        result.data = new float[this.data.length][];
        for (int i = 0; i < this.data.length; i++) {
            result.data[i] = this.data[i].clone();
            for (int j = 0; j < result.data[i].length; j++) {
                result.data[i][j] += other.data[i][j];
            }
        }
        return result;
    }

    /**
     * Adds value to each element in place.
     *
     * @param value scalar to add
     */
    public void addEquals(float value) {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                this.data[i][j] += value;
            }
        }
    }

    /**
     * Adds another Ndarray element-wise in place.
     * Shapes must match.
     *
     * @param other Ndarray to add
     */
    public void addEquals(Ndarray other) {
        if (other == null || this.ndim != other.ndim
                || this.shape[0] != other.shape[0]
                || this.shape[1] != other.shape[1]) {
            throw new IllegalArgumentException("Shapes must match for element-wise addition");
        }
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                this.data[i][j] += other.data[i][j];
            }
        }
    }
}
