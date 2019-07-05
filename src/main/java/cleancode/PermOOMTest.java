package cleancode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2019/1/15.
 */
public class PermOOMTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        int i =0;
        while (true){
            list.add(String.valueOf(i++).intern());

        }
    }
}
