package concurrent;

/**
 * Created by xufei on 2020/5/22.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(55);

        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(56);

        ThreadLocal<Integer> threadLocal3 = new ThreadLocal<>();
        threadLocal3.set(57);

        ThreadLocal<Integer> threadLocal4 = new ThreadLocal<>();
        threadLocal4.set(58);

        System.out.println(threadLocal1.get());

        threadLocal1.remove();

    }

}
