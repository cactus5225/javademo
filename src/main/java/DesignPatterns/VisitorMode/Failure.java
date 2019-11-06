package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public class Failure extends Action {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getName()+"失败时,闷头喝酒，谁也不用劝");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getName()+"失败是，眼泪汪汪，谁也劝不了");
    }
}
