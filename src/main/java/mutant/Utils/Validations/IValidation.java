package mutant.Utils.Validations;

import mutant.Exceptions.InvalidException;

public interface IValidation {

    void validate(String[] dnaStrings) throws InvalidException;
}
