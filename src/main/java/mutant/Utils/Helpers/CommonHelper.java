package mutant.Utils.Helpers;


import mutant.Utils.Static.Constants;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * @param stringToValidate
     * @param validChars
     * @return
     */
    public static boolean containValidChars(String stringToValidate,String validChars){
        String regExpValidation= "^["+ new String(validChars) +"]+$";
        return stringToValidate.matches(regExpValidation);
    }

    public static int countMatchesString(String origin,int found,int minSequences){
        if (origin.isEmpty())
            return 0;
        String rexExp = "([" + Constants.VALIDCHARS + "])\\1{3}";
        Pattern p = Pattern.compile(rexExp);
        Matcher m = p.matcher(origin);
        int count = 0,start = 0;
        while(m.find(start) && (found + count <minSequences)) {
            count++;
            start = m.start() + 1;
        }
        return count;
    }
}
