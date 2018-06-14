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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MutantIntegrationTest extends FunctionalTest{

    @Autowired
    private DNARepository dnaRepository;

    @Test
    public void basicPingTest() {
        dnaRepository.deleteAll();
        String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        Map<String,String[]> sequence = new HashMap<>();
        sequence.put("dna", array);


        given()
                .contentType("application/json")
                .body(sequence)
                .when().post("/mutant").then()
                .statusCode(200);
    }

}