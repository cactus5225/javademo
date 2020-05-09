package concurrent;

/**
 * Created by xufei on 2020/4/26.
 */
public class ThreadSleepTest {

    private boolean flag = false;

    public static void main(String[] args) {
        ThreadSleepTest threadSleepTest = new ThreadSleepTest();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (!threadSleepTest.flag){
                    try {
                        Thread.sleep(200000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadSleepTest.flag= true;
            }
        });
    }
}
