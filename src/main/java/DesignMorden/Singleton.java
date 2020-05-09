package DesignMorden;

/**
 * Created by xufei on 2020/5/7.
 */
public class Singleton {
    private static Singleton singleton;

    //私有化构造函数
    private Singleton() {
    }

    //给出一个公共的静态方法返回一个单一实例
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
