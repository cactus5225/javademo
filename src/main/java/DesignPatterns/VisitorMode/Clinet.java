package DesignPatterns.VisitorMode;

import jvm.SubClass;

/**
 * Created by xufei on 2019/10/10.
 */
public class Clinet {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Success v1 = new Success();
        objectStructure.display(v1);

        Failure f1 = new Failure();
        objectStructure.display(f1);

        Marry m1 = new Marry();
        objectStructure.display(m1);

    }

}
