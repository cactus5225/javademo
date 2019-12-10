package DataStructureAndAlgorithms;

import java.util.Arrays;

/**
 * Created by xufei on 2019/11/25.
 */
public class CopyingArrays {

    public static void main(String[] args) {
        int [] i = new int[7];
        int [] j = new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,49);
        System.out.println("i = " +Arrays.toString(i));
        System.out.println("j = " +Arrays.toString(j));
        System.arraycopy(i,0,j,0,i.length);

        System.out.println("复制i的数据到j = " +Arrays.toString(j));




    }

}
