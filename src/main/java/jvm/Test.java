package jvm;

import java.util.concurrent.TimeUnit;

/**
 * Created by xufei on 2020/4/14.
 * -Xms1555M  -Xmx1555M  -XX:+UseConcMarkSweepGC -XX:NativeMemoryTracking=detail -XX:PretenureSizeThreshold=3072
 */
public class Test {


    private static final int ONE_MB = 1024 * 1024;
    private static final int FIVE_MB = 5 * 1024 * 1024;


    public static void main(String[] args) {

        //快速把内存占满
        for (int i = 0; i < 2000; i++) {
            //申请20M Young空间
            allocateYoungSpace(500);
            //申请20M 老年代空间
            allocateOldSpace(500);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        for (int i = 0; i < 100000; i++) {
            //申请20M Young空间
            allocateYoungSpace(2);
            //申请20M 老年代空间
            allocateOldSpace(5);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 申请Young空间占用
     *
     * @param mSize 单位MB
     */
    private static void allocateYoungSpace(int mSize) {

        System.out.println("Allcate YoungSpace , size = " + mSize + "MB");

        for (int i = 0; i < mSize; i++) {

            byte[] memBytes = new byte[ONE_MB];
            System.out.println(memBytes);


        }

        System.out.println("Allcate YongSpace done");

    }

    /**
     * 申请Old空间占用。 需要配合XX:PretenureSizeThreshold参数，表示超过设置大小之后，对象直接放到老年代。
     * 本程序，我们设定参数的值为3M，即对象超过3M就会进入到老年代
     *
     * @param mSize
     */
    private static void allocateOldSpace(int mSize) {
        System.out.println("Allcate OldSpace , size = " + mSize + "MB");

        for (int i = 0; i < mSize / 5; i++) {
            byte[] memBytes = new byte[FIVE_MB];
        }

        if (mSize % 5 != 0) {
            byte[] additionMem = new byte[mSize % 5 * ONE_MB];
        }

        System.out.println("Allcate OldSpace done");


    }

    @org.junit.Test
    public void test() {
        String a ="err";

        a = "asdf";
        System.out.println(a);
    }

}


