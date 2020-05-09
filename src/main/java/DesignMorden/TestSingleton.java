package DesignMorden;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xufei on 2020/5/7.
 *
 * 比较有意思的是我第二次测试的时候出来三个实例，但是之后测试就不会出现
 */
public class TestSingleton {

    volatile static Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i <1000; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.countDown();
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    Singleton singleton = Singleton.getInstance();
                    SynchronizedSingleton singleton = SynchronizedSingleton.getInstance();
                    instanceSet.add(singleton.toString());
                }
            });
        }



        System.out.println("------并发情况下我们取到的实例------");

        Thread.sleep(5000);
        for (String instance : instanceSet) {
            System.out.println(instance);
        }
        executorService.shutdown();
    }
}
