import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xufei on 2019/8/14.
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) throws Exception{
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for( int i =0;i<10 ;i++){
            System.out.println("开始任务" + sdf.format(new Date()));
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Work start, i"  +"thread id:"+ Thread.currentThread().getId() + " " + sdf.format(new Date()));
                }
            };
            Thread.sleep(120);

            System.out.println(i+"sleep"+sdf.format(new Date()));
            service.schedule(runnable, 1, TimeUnit.SECONDS);

        }
    }

}
