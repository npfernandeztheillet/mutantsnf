package mutant.Data;


import mutant.Business.DTOs.DNADTO;
import mutant.Data.Model.DNA;
import mutant.Data.Repository.DNARepository;
import mutant.Utils.Static.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static mutant.Utils.Helpers.CommonHelper.getRandomMatrix;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DNAJpaTest {

    private static final int SIZE = 10;

    @Autowired
    private DNARepository dnaRepository;

    @Before
    public void setup() {
        dnaRepository.deleteAll();
    }

    @Test
    public void getByDNATest() {
        String[] array = getRandomMatrix(Constants.VALIDCHARS,SIZE);
        DNA dnaToTests = new DNA(array);
        dnaRepository.save(dnaToTests);
        DNADTO dnaDTO = dnaRepository.getByDNA(dnaToTests.getDNA());
        Assert.assertEquals(dnaToTests.getDNA(),dnaDTO.getDNA());
    }

    @Test
    public void findByDNATest() {
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        DNA dnaToTests = new DNA(array);
        dnaRepository.save(dnaToTests);
        int EntityId= dnaRepository.findByDNA(dnaToTests.getDNA());
        Assert.assertNotEquals(0,EntityId);
    }

    @Test
    public void saveTest() {
        String[] array = getRandomMatrix(Constants.VALIDCHARS,SIZE);
        DNA dnaToTests = new DNA(array);
        DNA entitySaved=null;
        long idToFind=dnaRepository.findByDNA(dnaToTests.getDNA());
        if(idToFind>0)
            dnaRepository.deleteById(idToFind);
        try{
            dnaToTests.setIsMutant(true);
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