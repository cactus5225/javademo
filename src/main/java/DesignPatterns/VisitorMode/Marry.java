package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public class Marry extends Action {
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getName()+"恋爱时,凡事不懂也要装懂");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getName()+"恋爱时，遇事懂也装作不懂");
    }
}
