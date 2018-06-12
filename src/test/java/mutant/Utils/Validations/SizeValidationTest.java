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

public class SizeValidationTest {

    private static final String validChars ="ATCG";
    private static final int size = 3;

    @Test
    public void validationSameSizeTest() {
        String matrix[] = CommonHelper.getRandomMatrix(validChars,size);
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