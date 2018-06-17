package mutant.Business.Validations;

import mutant.Exceptions.InvalidException;

/**
 * Interface that exposes validate method to be used by the different classes of business validations.
 */
interface IValidation {

    void validate(String[] dnaStrings) throws InvalidException;
}
