package mutant.Utils.Helpers;


import java.security.SecureRandom;

public class MatrixHelper {


    /**
     * @param matrix
     * @param count
     * Discard diagonals smaller than 4 (-4).
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

    //If count = 0 it's the main diagonal.
    public static String getDownDiagonal(String [] matrix,int count,boolean inverse) {
        int size = matrix.length;
        StringBuilder sb = new StringBuilder();
        //TODO check if row is <size-4
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

    public static String transposeMatrizColumn(String []matriz,int column) {
        StringBuilder sb = new StringBuilder();
        int size = matriz.length;
        sb.setLength(size);
        for (int i = 0, j = size - 1, x = 0; i <= j; ) {
            sb.setCharAt(x++, matriz[i++].charAt(column));
            if (i > j) break;
            sb.setCharAt(j,  matriz[j--].charAt(column));
        }
        return sb.toString();
    }

}
