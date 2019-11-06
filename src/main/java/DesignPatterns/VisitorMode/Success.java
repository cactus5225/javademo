package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public class Success extends  Action{

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getName()+"成功时背后多半有一个伟大的女人");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getName()+"成功时背后多半有个一个不成功的男人");

    }
}
