import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by xufei on 2019/7/2.
 */
public class Test {

    @org.junit.Test
    public void toStringSetAndMap(){
        HashMap hashMap = new HashMap();
        hashMap.put("name","zhangsan");
        //println的方法可以直接打印内容而不是打印内存地址。
        System.out.println(hashMap);

        HashSet hashSet = new HashSet();
        hashSet.add("zhangsan");
        System.out.println(hashSet);

        Hashtable hashtable = null;
        System.out.println(hashtable);
    }


    @org.junit.Test
    public void testnanoTimeAndcurrentTimeMillis(){
        //返回当前时间的纳秒值。
        System.out.println(System.nanoTime());
        //从1970年1月1号半夜12点到当前时间的毫秒值
        System.out.println(System.currentTimeMillis());
    }

    /**
     * gavua限流是1秒呢匀速的生成令牌，而不是一下子就生成好的。
     */
    @org.junit.Test
    public void testRate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");

        RateLimiter rateLimiter = RateLimiter.create(2);

        while(true) {

            rateLimiter.acquire();

            System.out.println(simpleDateFormat.format(new Date()));

        }
    }

    @org.junit.Test
    public void testFinally(){

        if (3>1){
            return;
        }

        try {
            System.out.println("try");
        }finally {
            System.out.println("finally执行");

        }
    }

    @org.junit.Test
    public void testSemaphore(){
        final Semaphore sp = new Semaphore(3);//创建一个Semaphore信号量，并设置最大并发数为3

        //availablePermits() //用来获取当前可用的访问次数
        System.out.println("初始化：当前有" + (3 - sp.availablePermits() + "个并发"));

        //创建10个任务，上面的缓存线程池就会创建10个对应的线程去执行
        for (int index = 0; index < 10; index++) {
            final int NO = index;  //记录第几个任务
            Runnable run = new Runnable() {  //具体任务
                public void run() {
                    try {
                        sp.acquire();  // 获取许可
                        System.out.println(Thread.currentThread().getName() + "获取许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
                        Thread.sleep(5000);
                        // 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
                        sp.release();  //释放许可
                        System.out.println(Thread.currentThread().getName() + "释放许可" + "("+NO+")，" + "剩余：" + sp.availablePermits());
                    } catch (Exception e) {
                        System.out.println("异常。。。"+e);
                    }
                }
            };
            run.run();
        }
    }

    @org.junit.Test
    public void getPath(){
        System.out.println(System.getProperty("user.dir")+"/src/main/resources/innerclass.txt");//user.dir指定了当前的路径
    }


}
