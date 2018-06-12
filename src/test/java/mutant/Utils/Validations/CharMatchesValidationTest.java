package mutant.Utils.Validations;


import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)

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