package mutant.Business;

import mutant.Business.DTOs.DNADTO;
import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Helpers.MatrixHelper;
import mutant.Business.Validations.CharMatchesValidation;
import mutant.Business.Validations.SizeValidation;

/**
 * Class responsible for implementing business rules.
 */
public class MutantBusiness {

    /**
     * Number of characters to consider a match of DNA
     */
    private int consecutiveChars;

    /**
     * Minimum amount of matches to consider that the DNA sequence corresponds to a mutant sequence.
     */
    private int minSequences;

    public MutantBusiness(int consecutiveChars, int minSequences){
        this.consecutiveChars = consecutiveChars;
        this.minSequences = minSequences;
    }

    /**
     * Validate if the dna sequence is valid.
     * @param dnaDTO Dto object for DNAs
     * @throws InvalidException
     */
    public void validateDNA(DNADTO dnaDTO)throws InvalidException{
        CharMatchesValidation charValidation = new CharMatchesValidation();
        SizeValidation sizeValidation = new SizeValidation();
        sizeValidation.validate((dnaDTO.getSequence()));
        charValidation.validate(dnaDTO.getSequence());
    }

    /**
     * Method that is responsible for checking if a sequence of DNA is mutant.
     * All Matrix with size lower than 4 are no mutant.After check that, check in horizontal. Then vertically (transposing and check horizontal) and finally diagonally (in the 2 diagonal directions)
     * @param dnaDTO
     * @return DTO updated regarding if it is mutant or not.
     * @throws InvalidException
     */
    public DNADTO analyseDna(DNADTO dnaDTO) throws InvalidException {
        dnaDTO.setIsMutant(checkIsMutant(dnaDTO));
        return dnaDTO;
    }

    /**
     * Method that is responsible for checking if a sequence of DNA is mutant
     * All Matrix with size lower than 4 are no mutant.
     * First check in horizontal. Then vertically transposing and finally diagonally (in the 2 diagonal directions)
     * @param dnaDTO
     * @return true if it complies with the business rules (at least have minSequences sequences of 4 consecutive characters).
     */
    private boolean checkIsMutant(DNADTO dnaDTO){
        int found = 0;
        String matrix[] = dnaDTO.getSequence();
        int size = matrix.length;
        //Check size
        if (size > 0 && size <4) //All Matrix with size lower than 4 are no mutant.
            return false;

        //Check horizontal rule.
        for (int i = 0; i <size && found<minSequences ; i++)
            found+=CommonHelper.countMatchesString(matrix[i],found,minSequences);

        //Check vertical (using transpose and check horizontal) rule.
        for (int i = 0; i <size && found<minSequences ; i++) {
            found+=CommonHelper.countMatchesString(MatrixHelper.transposeMatrixColumn(matrix,i),found,minSequences);
        }

        //Check diagonals in both ways
        for (int i = 0; i <= size-4 && found<minSequences; i++) {
            found+=CommonHelper.countMatchesString(MatrixHelper.getBelowDiagonal(matrix, i, true),found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getBelowDiagonal(matrix, i, false),found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getUpperDiagonal(matrix, i, true),found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getUpperDiagonal(matrix, i, false),found,minSequences);
        }

        if (found < minSequences)
            return false;
        return true;
    }

}
