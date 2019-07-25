package jvm;

/**
 * Created by xufei on 2019/7/25.
 *
 */
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello, Java!");
        if (flag == true) System.out.println("Hello, JVM!");
    }
}
/**
 * jvm把boolean当做int来处理
 * flag = iconst_1 = true
 * awk把stackframe中的flag改为iconst_2
 * if（flag）比较时ifeq指令做是否为零判断，常数2仍为true，打印输出
 * if（true == flag）比较时if_cmpne做整数比较，iconst_1是否等于flag，比较失败，不再打印输出
 *
 *
 * javac jvm.Foo.java
 * java jvm.Foo
 * java-cp /path/to/asmtools.jar   org.openjdk.asmtools.jdis.Main  jvm.Foo.class>jvm.Foo.jasm.1
 * awk'NR==1,/iconst_1/{sub(/iconst_1/,"iconst_2")}1'jvm.Foo.jasm.1>jvm.Foo.jasm
 * java-cp  /path/to/asmtools.jar    org.openjdk.asmtools.jasm.Main    jvm.Foo.jasm
 * javaFoo
 *
 * asmtools.jar下载路径：https://github.com/hengyunabc/hengyunabc.github.io/files/2188258/asmtools-7.0.zip
 *
 */
