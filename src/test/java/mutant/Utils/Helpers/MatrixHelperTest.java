package mutant.Utils.Helpers;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MatrixHelperTest {

    private int addAllDirections(String []matrix,ArrayList<String> arrayList){
        int size= matrix.length;
        arrayList = new ArrayList<>();
        for (int i = 0; i <= size-4; i++) {
            arrayList.add(MatrixHelper.getDownDiagonal(matrix, i, true));
            arrayList.add(MatrixHelper.getDownDiagonal(matrix, i, false));
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
        Assert.assertEquals(6,addAllDirections(matrix,arrayList));
        matrix = new String[]{"ABCD","EFGH","IJKL","MNOP"};
        addAllDirections(matrix,arrayList);
        Assert.assertEquals(2,addAllDirections(matrix,arrayList));
        matrix = new String[]{"ABCDEF","GHIJKL","MNOPQR","STUVWX","YZ1234","567890"};
        addAllDirections(matrix,arrayList);
        Assert.assertEquals(10,addAllDirections(matrix,arrayList));
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
        Assert.assertEquals(MatrixHelper.getDownDiagonal(matrix,0,false),resultDiagonal);
        String resultInverseDiagonal = "VRNJ";
        Assert.assertEquals(MatrixHelper.getDownDiagonal(matrix,1,true),resultInverseDiagonal);
    }


    @Test
    public void transposeMatrizColumnTest() {
        String[] matrix = new String[]{"ABC","DEF","GHI"};
        String firstMatch = "ADG";
        String secondMatch = "BEH";
        String thirdMatch = "CFI";
        Assert.assertEquals(MatrixHelper.transposeMatrizColumn(matrix,0),firstMatch);
        Assert.assertEquals(MatrixHelper.transposeMatrizColumn(matrix,1),secondMatch);
        Assert.assertEquals(MatrixHelper.transposeMatrizColumn(matrix,2),thirdMatch);
    }

}