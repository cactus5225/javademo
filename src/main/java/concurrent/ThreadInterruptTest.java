package concurrent;

import org.junit.Test;

/**
 * Created by xufei on 2020/4/22.
 * <p>
 * 1.Thread.interrupt()方法和InterruptedException异常的关系？是由interrupt触发产生了InterruptedException异常？
 * <p>
 * 2.Thread.interrupt()会中断线程什么状态的工作？ RUNNING or BLOCKING？
 * <p>
 * 3.一般Thread编程需要关注interrupt中断不？一般怎么处理？可以用来做什么？
 * <p>
 * 4.LockSupport.park()和unpark()，与object.wait()和notify()的区别？
 * <p>
 * 5.LockSupport.park(Object blocker)传递的blocker对象做什么用？
 * <p>
 * 6.LockSupport能响应Thread.interrupt()事件不？会抛出InterruptedException异常？
 * <p>
 * 7.Thread.interrupt()处理是否有对应的回调函数？类似于钩子调用？
 * <p>
 * <p>
 * -------------------------------------------------
 * Thread 类中的实例方法，持有线程实例引用即可检测线程中断状态
 * public boolean isInterrupted() {}
 * ---------------------------------------------------
 * <p>
 * ---------------------------------------------------------
 * Thread 中的静态方法，检测调用这个方法的线程是否已经中断
 * 注意：这个方法返回中断状态的同时，会将此线程的中断状态重置为 false
 * 所以，如果我们连续调用两次这个方法的话，第二次的返回值肯定就是 false 了
 * public static boolean interrupted() {}
 * ---------------------------------------------------------
 * <p>
 * ---------------------------------------------------------
 * Thread 类中的实例方法，用于设置一个线程的中断状态为 true
 * public void interrupt() {}
 * ---------------------------------------------------------
 */
public class ThreadInterruptTest {


    @Test
    public void testInterrupted() {
        Thread.currentThread().interrupted();
        System.out.println("第一次调用返回值" + Thread.interrupted());
        System.out.println("第二次调用返回值" + Thread.interrupted());
    }


}
