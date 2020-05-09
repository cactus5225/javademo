package base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2020/4/11.
 * String/StringBUffer/StringBuild的区别
 * String是不可变的类，属性也是不可变的，所以类似拼接，裁剪字符等动作都会产生新的String对象
 * StringBUffer线程安全，维护了一个char[]
 * StringBuild线程不安全
 * <p>
 * <p>
 * 场景一
 * javac 把.java文件变为.class文件
 * javap -v .class 反编译
 * <p>
 * <p>
 * <p>
 * +连接字符串会被自动识别为StringBuild
 */
public class StringContrast {

    @Test
    public void test() {
        String myStr = "aa" + "bb" + "cc" + "dd";
//        concat("AA");
    }
//
//    public static String concat(String str) {
//        return str + "aa" + "bb";
//    }

    /**
     * string pool中存的是引用值而不是具体的实例对象，具体的实例对象是在堆中开辟的一块空间存放的

     */
    @Test
    public void testEqual() {
        /**
         *  采用字面值的方式创建一个字符串时，JVM首先会去字符串池中查找是否存在"abc"这个对象，
         * 如果不存在，则在字符串池中创建"abc"这个对象，然后将池中"abc"这个对象的引用地址返回给"abc"对象的引用s1，
         * 这样s1会指向池中"abc"这个字符串对象；如果存在，则不创建任何对象，直接将池中"abc"这个对象的地址返回，赋给引用s2。
         * 因为s1、s2都是指向同一个字符串池中的"abc"对象，所以结果为true。
         */
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = new String("xyz");
        String s4 = new String("xyz");
        System.out.println(s3 == s4);


        String s5 = "dfg";
        String s6 = new String("dfg");
        System.out.println(s5 == s6);
    }

    @Test
    public void test1() {
        String str = "abc";
        char data[] = {'a', 'b', 'c'};
        String str1 = new String(data);
        System.out.println(str == str1);
    }

    /**
     * jdk1.8字符串常量池在堆里
     */
    @Test
    public void testHeap() {
        String base = "string";

        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }


}
