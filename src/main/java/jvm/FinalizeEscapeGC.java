package jvm;

/**
 * Created by xufei on 2019/9/27.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes，i am still alive");
    }


    protected void finalieze () throws Throwable {
        super.finalize();
        System.out.println("finalieze method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;

    }

    /**
     * finalize方法自会被调用一次
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = null;
        System.gc();//调用finalize方法，对象自救成功

        //一分钟都没有复现成功，
        Thread.sleep(1000*60*5);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }


        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }

    }

}
