package mutant.Utils.Helpers;

/**
 * Class responsible for helping with operations on matrix.
 */
public class MatrixHelper {
    /**
     * Method responsible for obtaining a diagonal above the main diagonal of the matrix
     * @param matrix character matrix (dna sequence)
     * @param count number of column or row (depending on the search direction)
     * @param inverse false if search diagonals from left to right and from top to bottom, true search in the other way.
     * @return
     */
    public static String getUpperDiagonal(String [] matrix,int count,boolean inverse) {
        StringBuilder sb = new StringBuilder();
        int size = matrix.length;
        int column=size-4-count;

        if (!inverse){
            for(int i=0; i<size && (column + i) < size && column>0; i++){
                sb.append(matrix[i].charAt(column + i));
            }
        }

        if (inverse){
            for (int col = 0 ,row=size-count-1; row>=0 ; col++ , row--) {
                sb.append(matrix[row].charAt(col));
            }
        }
        return sb.toString();
    }

    /**
     * Method responsible for obtaining a diagonal below the main diagonal of the matrix (if count =0 it's the main diagonal)
     * @param matrix character matrix (dna sequence)
     * @param count number of column or row (depending on the search direction)
     * @param inverse false if search diagonals from left to right and from top to bottom, true search in the other way.
     * @return
     */
    public static String getBelowDiagonal(String [] matrix, int count, boolean inverse) {
        int size = matrix.length;
        StringBuilder sb = new StringBuilder();
        if (!inverse) {
            for (int j = count, k = 0; j < size && k < size; j++, k++)
                sb.append(matrix[j].charAt(k));
        }
        if (inverse){
            for (int col = count ,row=size-1 ; col<size && row>=0 && col>0; col++ , row--) {
                sb.append(matrix[row].charAt(col));
            }
        }
        return sb.toString();
    }

    /**
     * Method responsible for transposing a column of a matrix.
     * @param matrix character matrix (dna sequence)
     * @param column column to transpose.
     * @return column transposed
     */
    public static String transposeMatrixColumn(String []matrix, int column) {
        StringBuilder sb = new StringBuilder();
        int size = matrix.length;
        sb.setLength(size);
        for (int i = 0, j = size - 1, x = 0; i <= j; ) {
            sb.setCharAt(x++, matrix[i++].charAt(column));
            if (i > j) break;
            sb.setCharAt(j,  matrix[j--].charAt(column));
        }
        return sb.toString();
    }

}
