import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xufei on 2019/9/16.
 */
public class HelloWorld {

    public static void main(String[] args) {
        //1.打印系统配置数据
//        System.getProperties().list(System.out);


        //2.填充容器的方式
//        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("HelloWorld")));
//        System.out.println(list);

        //3.spring创建bean工厂
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationfile.xml");

        //4.Interger缓存
//        Integer num1 = new Integer(100);
//        Integer num2 = new Integer(100);
//        System.out.println("num1==num2 " + (num1 == num2));
//
//        Integer num3 = 100;
//        Integer num4 = 100;
//        System.out.println("num3==num4 " + (num3 == num4));
//
//        Integer num5 = 128;
//        Integer num6 = 128;
//        System.out.println("num5==num6 " + (num5 == num6));
//
//        Integer num7 = 100;
//        Integer num8 = new Integer(100);
//        System.out.println("num7==num8 " + (num7 == num8));
//
//        int num9 = 100;
//        Integer num10 = new Integer(100);
//        Integer num11 = 100;
//        System.out.println("num9==num10 " + (num9 == num10));//比较值相等
//        System.out.println("num9==num11 " + (num9 == num11));//比较值相等


        //5.Long缓存
//        Long num1= 100L;

        //6.Stirng常量池的缓存机制
        String a = "123";


    }
}
