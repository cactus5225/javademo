package concurrent;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xufei on 2020/4/22.
 * <p>
 * APS使用了FIFO的双向链表的阻塞队列
 */
public class AqsTest {

    @Test
    public void testAqs() {
        ReentrantLock reentrantLock = new ReentrantLock(true);

        // 比如我们同一时间，只允许一个线程创建订单
        reentrantLock.lock();
        // 通常，lock 之后紧跟着 try 语句
        try {
            // 这块代码同一时间只能有一个线程进来(获取到锁的线程)，
            // 其他的线程在lock()方法上阻塞，等待获取到锁，再进来
            // 执行代码...
            // 执行代码...
            // 执行代码...
        } finally {
            // 释放锁
            reentrantLock.unlock();
        }

    }


}
