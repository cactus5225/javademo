package DesignMorden;

/**
 * Created by xufei on 2020/5/7.
 *
 * 利用jvm强行同步，一个类的静态属性只会在第一次加载类时初始化。
 */
public class SingletonBetter {

    private SingletonBetter() {
    }

    public static SingletonBetter getInstance() {
        return SingletonInstance.instance;
    }

    private static class SingletonInstance {

        static SingletonBetter instance = new SingletonBetter();

    }
}
