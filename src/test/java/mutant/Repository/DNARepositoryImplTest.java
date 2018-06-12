package mutant.Repository;


import mutant.Model.DNA;
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

    private static final String VALIDCHARS ="ATCG";
    private static final int SIZE = 10;

    @Autowired
    private DNARepositoryImpl dnaRepository;

    @Test
    public void saveTest() {
        String[] array = getRandomMatrix(VALIDCHARS,SIZE);
        DNA dnaToTests = new DNA(array);
        DNA entitySaved=null;
        try{
            entitySaved= dnaRepository.save(dnaToTests);
        }catch (Exception e){
            Assert.fail();
        }
        Assert.assertNotNull(dnaRepository.findByDNA(entitySaved.getDNA()));
    }
}