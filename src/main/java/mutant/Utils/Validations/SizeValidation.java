package mutant.Utils.Validations;

import mutant.Exceptions.InvalidException;

public class SizeValidation implements IValidation{

    @Override
    public void validate(String[] sequence) throws InvalidException {
        int size = sequence.length;

        for (String matrixEntry:sequence) {
            if(matrixEntry.length() != size){
                throw new InvalidException(matrixEntry + " size does not match the array size");
            }
        }
    }

}
