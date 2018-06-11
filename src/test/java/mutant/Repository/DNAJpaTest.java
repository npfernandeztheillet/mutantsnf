package mutant.Repository;


import mutant.Model.DNA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static mutant.Utils.Helpers.CommonHelper.getRandomMatrix;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNAJpaTest {

    private static final String validChars="ATCG";

    @Autowired
    private DNARepository dnaRepository;

    @Before
    public void setup() {
        dnaRepository.deleteAll();
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
        String[] array = getRandomMatrix(validChars,4);
        DNA dnaToTests = new DNA(array);
        DNA entitySaved=null;
        long idToFind=dnaRepository.findByDNA(dnaToTests.getDNA());
        if(idToFind>0)
            dnaRepository.deleteById(idToFind);
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