package mutant.Utils.Helpers;


import mutant.Utils.Static.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Class responsible for test Common Helper methods.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CommonHelperTest {
    private static final int SIZE = 5;

    @Test
    public void concatArrayByDelimiterTest() {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        String concat= CommonHelper.concatArrayByDelimiter(array,Constants.DELIMITER);
        String expected="ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG";
        Assert.assertEquals(expected,concat);
    }

    @Test
    public void getRandomStringTest() {
        String firstString = CommonHelper.getRandomString(Constants.VALIDCHARS,SIZE);
        String secondString = CommonHelper.getRandomString(Constants.VALIDCHARS,SIZE);
        Assert.assertNotNull(firstString,secondString);
    }

    @Test
    public void getRandomMatrixTest() {
        String firstMatrix[] = CommonHelper.getRandomMatrix(Constants.VALIDCHARS,SIZE);
        String secondMatrix[] = CommonHelper.getRandomMatrix(Constants.VALIDCHARS,SIZE);

        Assert.assertNotNull(firstMatrix.toString(),secondMatrix.toString());
    }

    @Test
    public void countMatchesStringTest() {
        int result = CommonHelper.countMatchesString("AAAAA",0,2);
    }

}