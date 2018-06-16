package mutant.Business.Validations;

import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import static mutant.Utils.Static.Constants.VALIDCHARSREGEXP;


/**
 * Class responsible for validating that a matrix contains only valid characters.
 */
public class CharMatchesValidation implements IValidation{
    @Override
    public void validate(String[] sequence) throws InvalidException {
        for (String matrixEntry:sequence) {
            if (!CommonHelper.containValidChars(matrixEntry,VALIDCHARSREGEXP))
                throw new InvalidException("Sequence contains illegal chars.");
        }
    }

}
