package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2020/4/21.
 * Java-ArrayList-subList()方法不恰当使用引起的OutOfMemoryError
 * https://blog.csdn.net/wang704987562/article/details/83107674
 */
public class ArrayListSubListTest {

    public static void main(String[] args) {
        List<List<Integer>> cache = new ArrayList<>();

        try {
            while (true) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < 100000; j++) {
                    list.add(j);
                }
//
//                List<Integer> sublist = list.subList(0, 1);
//                list.clear();
//                cache.add(sublist);
            }
        } finally {
            System.out.println("cache size = " + cache.size());
        }
    }
}
