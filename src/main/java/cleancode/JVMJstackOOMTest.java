package cleancode;

/**
 * Created by xufei on 2019/1/15.
 */
public class JVMJstackOOMTest {
    public static void main(String[] args) {
        JVMJstackOOMTest jvmJstackOOMTest = new JVMJstackOOMTest();
        jvmJstackOOMTest.stackLeak();
    }


    public void stackLeak() {
        while (true) {
            Thread thread = new Thread(() -> test());
            thread.start();
        }
    }

    public void test() {
        while (true) {

        }
    }
}
