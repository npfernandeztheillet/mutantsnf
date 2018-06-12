package mutant.Utils.Helpers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CommonHelperTest {

    private static final String validChars ="ATCG";
    private static final String delimiter ="-";
    private static final int size = 5;

    @Test
    public void concatArrayByDelimiterTest() {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String concat= CommonHelper.concatArrayByDelimiter(array,delimiter);
        String expected="ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG";
        Assert.assertEquals(expected,concat);
    }

    @Test
    public void getRandomStringTest() {
        String firstString = CommonHelper.getRandomString(validChars,size);
        String secondString = CommonHelper.getRandomString(validChars,size);
        Assert.assertNotNull(firstString,secondString);
    }

    @Test
    public void getRandomMatrixTest() {
        String firstMatrix[] = CommonHelper.getRandomMatrix(validChars,size);
        String secondMatrix[] = CommonHelper.getRandomMatrix(validChars,size);

        Assert.assertNotNull(firstMatrix.toString(),secondMatrix.toString());
    }

}