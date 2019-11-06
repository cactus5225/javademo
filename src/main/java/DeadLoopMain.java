/**
 * Created by xufei on 2019/9/16.
 */
public class DeadLoopMain {

    static  class DeadLooopClass{
        static {
            if (true){
                System.out.println(Thread.currentThread()+"init DeadLoopMain");
                while (true){

                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+ "start!!");
                DeadLooopClass deadLoopMain = new DeadLooopClass();
                System.out.println(Thread.currentThread()+"run over!!");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);

        thread1.start();
        thread2.start();

    }
}
