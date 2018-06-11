package mutant.Services;

import mutant.Exceptions.InvalidException;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    public MutantService(){
    }

    public boolean isMutant(String[] dna) throws InvalidException {
        throw new InvalidException("NOT IMPLEMENTED");
    }
}
