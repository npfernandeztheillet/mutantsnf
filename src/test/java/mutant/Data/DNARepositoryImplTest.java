package mutant.Data;


import mutant.Data.Model.DNA;
import mutant.Data.Repository.DNARepositoryImpl;
import mutant.Utils.Static.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static mutant.Utils.Helpers.CommonHelper.getRandomMatrix;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DNARepositoryImplTest {

    private static final int SIZE = 10;

    @Autowired
    private DNARepositoryImpl dnaRepository;

    @Test
    public void saveTest() {
        String[] array = getRandomMatrix(Constants.VALIDCHARS,SIZE);
        DNA dnaToTests = new DNA(array);
        DNA entitySaved=null;
        try{
            entitySaved= dnaRepository.save(dnaToTests);
        }catch (Exception e){
            Assert.fail();
        }
        Assert.assertNotNull(dnaRepository.findByDNA(entitySaved.getDNA()));
    }

    @Test
    public void saveDuplicateTest() {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNA dnaToTests = new DNA(array);
        try{
            dnaRepository.save(dnaToTests);
            dnaRepository.save(dnaToTests);
        }catch (Exception e){
            Assert.assertNotNull(e);
        }
    }
}