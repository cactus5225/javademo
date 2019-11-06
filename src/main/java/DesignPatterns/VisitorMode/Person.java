package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public abstract class Person {
    //人接受某种状态
    public abstract void accept(Action visitor);
}
