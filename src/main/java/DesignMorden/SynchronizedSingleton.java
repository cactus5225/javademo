package DesignMorden;

/**
 * Created by xufei on 2020/5/7.
 * <p>
 * 双重加锁
 * 首先要明白在JVM创建新的对象时，主要要经过三步。
 * <p>
 * 1.分配内存
 * <p>
 * 2.初始化构造器
 * <p>
 * 3.将对象指向分配的内存的地址
 * <p>
 * 步骤2和步骤3发生了重排序，然后后面的线程会拿到引用产生莫名的错误。
 * 使用volatile关键字之后后面的线程就可以看到主存中实时更新的数据了。
 */
public class SynchronizedSingleton {
    //一个静态的实例
    private volatile static SynchronizedSingleton synchronizedSingleton;

    //私有化构造函数
    private SynchronizedSingleton() {
    }

    //给出一个公共的静态方法返回一个单一实例
    public static SynchronizedSingleton getInstance() {
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (synchronizedSingleton == null) {
                    synchronizedSingleton = new SynchronizedSingleton();
                }
            }
        }
        return synchronizedSingleton;
    }


}
