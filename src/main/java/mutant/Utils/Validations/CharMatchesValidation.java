package mutant.Utils.Validations;

import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;

public class CharMatchesValidation implements IValidation{

    public static final String VALID_CHARS = "A,T,C,G";

    @Override
    public void validate(String[] sequence) throws InvalidException {
        for (String matrixEntry:sequence) {
            if (!CommonHelper.containValidChars(matrixEntry,VALID_CHARS))
                throw new InvalidException("Sequence contains illegal chars.");
        }
    }

}
