package mutant.Business;


import mutant.Business.DTOs.DNADTO;
import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Static.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MutantBusinessTest {

    @Test
    public void mutantTest() throws InvalidException {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNADTO dnaToTest = new DNADTO(array,CommonHelper.concatArrayByDelimiter(array,Constants.DELIMITER));
        MutantBusiness business = new MutantBusiness(4,2);
        boolean isMutant= business.analyseDna(dnaToTest).getIsMutant();
        Assert.assertEquals(true,isMutant);
    }

    @Test
    public void noMutantTest() throws InvalidException {
        String[] array = new String[]{"ATGC","GCTA","CCGG","TTAA"};
        DNADTO dnaToTest = new DNADTO(array,CommonHelper.concatArrayByDelimiter(array,Constants.DELIMITER));
        MutantBusiness business = new MutantBusiness(4,2);
        boolean isMutant= business.analyseDna(dnaToTest).getIsMutant();
        Assert.assertEquals(false,isMutant);
    }

    @Test
    public void noMutantLowerSizeFourTest() throws InvalidException {
        String[] array = new String[]{"ATG","CAG","TTA"};
        DNADTO dnaToTest = new DNADTO(array,CommonHelper.concatArrayByDelimiter(array,Constants.DELIMITER));
        MutantBusiness business = new MutantBusiness(4,2);
        boolean isMutant= business.analyseDna(dnaToTest).getIsMutant();
        Assert.assertEquals(false,isMutant);
    }

    @Test(expected = InvalidException.class)
    public void emptyDNATest() throws InvalidException {
        String[] array = new String[]{};
        DNADTO dnaToTest = new DNADTO(array,CommonHelper.concatArrayByDelimiter(array,Constants.DELIMITER));
        MutantBusiness business = new MutantBusiness(4,2);
        boolean isMutant= business.analyseDna(dnaToTest).getIsMutant();
    }


}