package cleancode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2019/1/15.
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/Users/xufei/Desktop/heapdump.hprof
 */
public class OOMTest {
    public static void main(String[] args) {
        List<OOMTest> list =new ArrayList<>();
        while (true){
            OOMTest oomTest = new OOMTest();
            list.add(oomTest);
        }

    }
}
