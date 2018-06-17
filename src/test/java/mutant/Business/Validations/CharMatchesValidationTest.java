package mutant.Business.Validations;


import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class responsible for test the char matches class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CharMatchesValidationTest {

    private static final String VALIDCHARS ="ATCG";
    private static final int SIZE = 3;

    @Test
    public void validationSameSizeTest() {
        String matrix[] = CommonHelper.getRandomMatrix(VALIDCHARS,SIZE);
        SizeValidation validation = new SizeValidation();
        try{
            validation.validate(matrix);
        }catch (InvalidException ie){
            Assert.fail(ie.getMessage());
        }
    }

    @Test
    public void validationDifferentSizeTest() {
        String[] matrix = new String[]{"ATGCGA"};
        SizeValidation validation = new SizeValidation();
        try{
            validation.validate(matrix);
        }catch (InvalidException ie){
            Assert.assertNotNull(ie.getMessage(),ie);
        }
    }

}