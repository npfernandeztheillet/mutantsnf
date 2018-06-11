package mutant.Utils.Helpers;


import java.security.SecureRandom;

public class CommonHelper {

    public static String concatArrayByDelimiter(String[] array,String delimiter){
        return String.join(delimiter,array);
    }
    public static String getRandomString(String validChars,int size){
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( size );
        for( int i = 0; i < size; i++ )
            sb.append( validChars.charAt( rnd.nextInt(validChars.length()) ) );
        return sb.toString();
    }

    public static String[] getRandomMatrix(String validChars,int size){
        String array[] = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomString(validChars,size);
        }
        return array;
    }
}
