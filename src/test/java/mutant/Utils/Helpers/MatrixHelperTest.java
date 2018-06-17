package mutant.Utils.Helpers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class responsible for test Matrix Helper methods.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MatrixHelperTest {

    private int addAllDirections(String[] matrix){
        int size= matrix.length;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i <= size-4; i++) {
            arrayList.add(MatrixHelper.getBelowDiagonal(matrix, i, true));
            arrayList.add(MatrixHelper.getBelowDiagonal(matrix, i, false));
            arrayList.add(MatrixHelper.getUpperDiagonal(matrix, i, true));
            arrayList.add(MatrixHelper.getUpperDiagonal(matrix, i, false));
        }
        arrayList.removeAll(Arrays.asList(null,""));
        return arrayList.size();
    }

    @Test
    public void getAllDiagonalsTest() {
        String[] matrix = new String[]{"ABCDE","FGHIJ","KLMNO","PQRST","UVWXY"};
        ArrayList<String> arrayList = new ArrayList<>();
        Assert.assertEquals(6,addAllDirections(matrix));
        matrix = new String[]{"ABCD","EFGH","IJKL","MNOP"};
        addAllDirections(matrix);
        Assert.assertEquals(2,addAllDirections(matrix));
        matrix = new String[]{"ABCDEF","GHIJKL","MNOPQR","STUVWX","YZ1234","567890"};
        addAllDirections(matrix);
        Assert.assertEquals(10,addAllDirections(matrix));
    }

    @Test
    public void getUpperDiagonalsTest() {
        String[] matrix = new String[]{"ABCDE","FGHIJ","KLMNO","PQRST","UVWXY"};
        String resultDiagonal = "BHNT";
        Assert.assertEquals(MatrixHelper.getUpperDiagonal(matrix,0,false),resultDiagonal);
        String resultInverse = "UQMIE";
        Assert.assertEquals(MatrixHelper.getUpperDiagonal(matrix,0,true),resultInverse);

    }

    @Test
    public void getDownDiagonalsTest() {
        String[] matrix = new String[]{"ABCDE","FGHIJ","KLMNO","PQRST","UVWXY"};
        String resultDiagonal = "AGMSY";
        Assert.assertEquals(MatrixHelper.getBelowDiagonal(matrix,0,false),resultDiagonal);
        String resultInverseDiagonal = "VRNJ";
        Assert.assertEquals(MatrixHelper.getBelowDiagonal(matrix,1,true),resultInverseDiagonal);
    }


    @Test
    public void transposeMatrizColumnTest() {
        String[] matrix = new String[]{"ABC","DEF","GHI"};
        String firstMatch = "ADG";
        String secondMatch = "BEH";
        String thirdMatch = "CFI";
        Assert.assertEquals(MatrixHelper.transposeMatrixColumn(matrix,0),firstMatch);
        Assert.assertEquals(MatrixHelper.transposeMatrixColumn(matrix,1),secondMatch);
        Assert.assertEquals(MatrixHelper.transposeMatrixColumn(matrix,2),thirdMatch);
    }

}