package mutant.API;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MutantIntegrationTest extends FunctionalTest{

        @Test
        public void basicPingTest() {
            String[] array = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            Map<String,String[]> sequence = new HashMap<>();
            sequence.put("dna", array);


            given()
                    .contentType("application/json")
                    .body(sequence)
                    .when().post("/mutant").then()
                    .statusCode(500);
        }


}