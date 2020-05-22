import org.junit.Test;

/**
 * Created by xufei on 2020/4/24.
 */
public class AllTest {

    public static void main(String[] args) {
        int sum =8;
        int index = 0;
        String result = "";
        for (int i = 1 ; ; i++) {
            if (fn(i) >= sum) {
                break;
            }
            result = result +fn(i);
        }

        System.out.println(result);



    }

    //
    private static   int fn( int n ){

        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 2;
        }

        return fn(n-1) + fn(n-2);

    }





}
