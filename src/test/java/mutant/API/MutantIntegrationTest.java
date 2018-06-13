package mutant.API;


import mutant.Repository.DNARepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
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