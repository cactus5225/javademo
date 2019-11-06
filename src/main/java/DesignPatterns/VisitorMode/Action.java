package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public abstract class Action {

    /**
     * 得到男人的反应
     */
    public abstract void getManConclusion(Man concreteElementA);

    /**
     * 得到女人的反应
     */
    public abstract void getWomanConclusion(Woman ConcreteElementB);

}
