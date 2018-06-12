package mutant.Utils.Helpers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)

public class CommonHelperTest {

    private static final String VALIDCHARS ="ATCG";
    private static final String DELIMITER ="-";
    private static final int SIZE = 5;

    @Test
    public void concatArrayByDelimiterTest() {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String concat= CommonHelper.concatArrayByDelimiter(array,DELIMITER);
        String expected="ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG";
        Assert.assertEquals(expected,concat);
    }

    @Test
    public void getRandomStringTest() {
        String firstString = CommonHelper.getRandomString(VALIDCHARS,SIZE);
        String secondString = CommonHelper.getRandomString(VALIDCHARS,SIZE);
        Assert.assertNotNull(firstString,secondString);
    }

    @Test
    public void getRandomMatrixTest() {
        String firstMatrix[] = CommonHelper.getRandomMatrix(VALIDCHARS,SIZE);
        String secondMatrix[] = CommonHelper.getRandomMatrix(VALIDCHARS,SIZE);

        Assert.assertNotNull(firstMatrix.toString(),secondMatrix.toString());
    }

}