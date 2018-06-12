package mutant.Services;

import mutant.DTOs.DNADTO;
import mutant.Exceptions.InvalidException;
import mutant.Repository.DNARepository;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Static.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    private DNARepository dnaRepository;

    public MutantService(){
    }

    public boolean isMutant(String[] dna) throws Exception {
        String dnaString = CommonHelper.concatArrayByDelimiter(dna, Constants.DELIMITER);
        DNADTO dnaDTO = dnaRepository.getByDNA(dnaString);
        if (dnaDTO == null){
            //TODO Analize matrix
            boolean isMutant = true;
            dnaRepository.save(new DNADTO(dna,dnaString,isMutant));
        }
        return dnaDTO.getIsMutant();
    }
}
