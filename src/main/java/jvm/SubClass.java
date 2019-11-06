package jvm;

/**
 * Created by xufei on 2019/8/30.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!!!");
    }

    public static String value = "Hello wold !!!";
    public static int a = 4;

}
