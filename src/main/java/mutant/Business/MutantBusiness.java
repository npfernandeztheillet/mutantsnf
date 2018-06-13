package mutant.Business;

import mutant.DTOs.DNADTO;
import mutant.Exceptions.InvalidException;
import mutant.Utils.Helpers.CommonHelper;
import mutant.Utils.Helpers.MatrixHelper;
import mutant.Utils.Static.Constants;
import mutant.Utils.Validations.CharMatchesValidation;
import mutant.Utils.Validations.SizeValidation;

import java.util.ArrayList;
import java.util.List;

public class MutantBusiness {

    private int consecutiveChars;
    private int minSequences;

    public MutantBusiness(int consecutiveChars, int minSequences){
        this.consecutiveChars = consecutiveChars;
        this.minSequences = minSequences;
    }

    private void validateDNA(DNADTO dnaDTO)throws InvalidException{
        CharMatchesValidation charValidation = new CharMatchesValidation();
        SizeValidation sizeValidation = new SizeValidation();
        sizeValidation.validate((dnaDTO.getSequence()));
        charValidation.validate(dnaDTO.getSequence());
    }

    public DNADTO analyseDna(DNADTO dnaDTO) throws InvalidException {
         validateDNA(dnaDTO);
        dnaDTO.setIsMutant(checkIsMutant(dnaDTO));
        return dnaDTO;
    }

    private boolean checkIsMutant(DNADTO dnaDTO){
        int found = 0;
        String matrix[] = dnaDTO.getSequence();
        int size = matrix.length;
        //Check size
        if (size > 0 && size <4) //All Matrix with size lower than 4 are no mutant.
            return false;

        //Check horizontal and vertical (using transpose) rules.
        for (int i = 0; i <size && found<minSequences ; i++) {
            found+=CommonHelper.countMatchesString(matrix[i],found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.transposeMatrizColumn(matrix,i),found,minSequences);
        }

        //Check diagonals
        for (int i = 0; i <= size-4 && found<minSequences; i++) {
            found+=CommonHelper.countMatchesString(MatrixHelper.getDownDiagonal(matrix, i, true)
                                    ,found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getDownDiagonal(matrix, i, false)
                    ,found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getUpperDiagonal(matrix, i, true)
                    ,found,minSequences);
            found+=CommonHelper.countMatchesString(MatrixHelper.getUpperDiagonal(matrix, i, false)
                    ,found,minSequences);
        }

        if (found < minSequences)
            return false;
        return true;
    }

}
