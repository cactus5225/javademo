package base;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * Created by xufei on 2020/5/17.
 */
public class TestWeakReference {


    /**
     * car没有被使用
     */
    @Test
    public void test() {

        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);

        int i = 0;

        while (true) {
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }


    /**
     * car被使用
     */
    @Test
    public void test1() {
        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i=0;

        while(true){
            //use the strong reference in the while loop
            System.out.println("here is the strong reference 'car' "+car);
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }


}
