package mutant.Business.Validations;

import mutant.Exceptions.InvalidException;

/**
 * Class responsible for validating that a matrix has a valid size (nxn and not empty).
 */
public class SizeValidation implements IValidation{

    @Override
    public void validate(String[] sequence) throws InvalidException {
        int size = sequence.length;

        if (size == 0)
            throw new InvalidException("dna is empty.");

        for (String matrixEntry:sequence) {
            if(matrixEntry.length() != size){
                throw new InvalidException(matrixEntry + " size does not match");
            }
        }
    }

}
