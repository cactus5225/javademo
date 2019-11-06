import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xufei on 2019/9/10.
 */
public class TimerTest {
    public static void main(String[] args) {

        System.out.println("timer begin....");
        Timer timer = new Timer();

        while (true){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!!!!");
                }
            },3000);

        }
    }


}
