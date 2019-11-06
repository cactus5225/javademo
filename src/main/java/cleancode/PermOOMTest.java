package cleancode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2019/1/15.
 * **************JDK1.7的参数设置**************
 * -XX:MaxPermSize=5m -XX:PermSize=5m
 * <p>
 * <p>
 * <p>
 * ******JDK1.8永久代的设置***********
 * -XX:MetaspaceSize=5m
 * 池化string对象被移到了java堆
 * -Xms20m -Xmx20m 设置为这个参数的时候很快的抛出了OOM
 * <p>
 * 符号引用被移到了native堆
 * 池化string对象被移到了java堆
 * Class对象、静态变量被移到了java堆
 */
public class PermOOMTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());

        }
    }
}
