package jvm;

/**
 * Created by xufei on 2019/8/30.
 */
public class Test {
    public static void main(String[] args) {
        //只初始化了父类，没有初始化子类，但是加载了子类。
//        System.out.println(SubClass.value);
//        SuperClass [] sca = new SuperClass[10];


        /**
         * 当子类没有重新定义同名属性时，子类父类共享该属性。
         * 当子类重新定义时，不共享，是两个不同变量，值不同。
         */
//        SuperClass superClass = new SuperClass();
//        System.out.println(superClass.value);
//        SubClass subClass = new SubClass();
//        System.out.println(subClass.value);
//        SuperClass sp = new SubClass();
//        System.out.println(sp.value);

        System.out.println(SuperClass.value);


    }
}
