package mutant.API;

import mutant.Exceptions.InvalidException;
import mutant.MutantApplication;
import mutant.Services.MutantService;
import mutant.Utils.Helpers.CommonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MutantController {

    private static final Logger logger = LoggerFactory.getLogger(MutantApplication.class);
    private static final String DELIMITER = "-";
    @Autowired
    private MutantService mutantService;


    @RequestMapping(value="/mutant", method = RequestMethod.POST)
    public ResponseEntity isMutant(@RequestBody RequestModel secuence){
        try {
            logger.debug("Analysing DNA: " + CommonHelper.concatArrayByDelimiter(secuence.dna,DELIMITER));
            if(mutantService.isMutant(secuence.dna)){
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }

        } catch (InvalidException e) {
            logger.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
