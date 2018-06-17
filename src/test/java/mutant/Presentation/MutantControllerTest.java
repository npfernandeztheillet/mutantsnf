package mutant.Presentation;


import mutant.Data.Repository.DNARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * Class responsible for test the Mutant controller endpoints.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MutantControllerTest extends ConfigurationAPITest{

    @Autowired
    private DNARepository dnaRepository;

    private Map<String,String[]> getDNAToPost(String [] dna){
        Map<String,String[]> sequence = new HashMap<>();
        sequence.put("dna", dna);
        return sequence;
    }

    @Test
    public void mutantAPITest() {
        dnaRepository.deleteAll();
        given()
                .contentType("application/json")
                .body(getDNAToPost(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}))
                .when().post("/mutant").then()
                .statusCode(200);
    }

    @Test
    public void noMutantAPITest() {
        dnaRepository.deleteAll();
        given()
                .contentType("application/json")
                .body(getDNAToPost(new String[]{"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"}))
                .when().post("/mutant").then()
                .statusCode(403);
    }

    @Test
    public void emptyDNAAPITest() {
        dnaRepository.deleteAll();
        given()
                .contentType("application/json")
                .body(getDNAToPost(new String[]{""}))
                .when().post("/mutant").then()
                .statusCode(500);
    }
}