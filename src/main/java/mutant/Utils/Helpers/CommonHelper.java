package mutant.Utils.Helpers;


import java.security.SecureRandom;

public class CommonHelper {

    /**
     * @param array array of strings to concatenate
     * @param delimiter delimiter to join the array elements.
     * @return string
     */
    public static String concatArrayByDelimiter(String[] array,String delimiter){
        return String.join(delimiter,array);
    }

    /**
     * @param validChars sequence of valid characters to generate the string.
     * @param size size of the string to generate.
     * @return generated string.
     */
    public static String getRandomString(String validChars,int size){
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( size );
        for( int i = 0; i < size; i++ )
            sb.append( validChars.charAt( rnd.nextInt(validChars.length()) ) );
        return sb.toString();
    }

    /**
     * @param validChars sequence of valid characters to generate the matrix.
     * @param size dimensions to the matrix to generate. (size x size)
     * @return generated matrix with random valid chars.
     */
    public static String[] getRandomMatrix(String validChars,int size){
        String array[] = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomString(validChars,size);
        }
        return array;
    }
}
