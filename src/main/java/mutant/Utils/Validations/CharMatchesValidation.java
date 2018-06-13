package mutant.Utils.Validations;

import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;

import static mutant.Utils.Static.Constants.VALIDCHARSREGEXP;

public class CharMatchesValidation implements IValidation{
    @Override
    public void validate(String[] sequence) throws InvalidException {
        for (String matrixEntry:sequence) {
            if (!CommonHelper.containValidChars(matrixEntry,VALIDCHARSREGEXP))
                throw new InvalidException("Sequence contains illegal chars.");
        }
    }

}
