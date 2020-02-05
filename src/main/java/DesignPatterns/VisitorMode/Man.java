package DesignPatterns.VisitorMode;

/**
 * Created by xufei on 2019/10/10.
 */
public class Man extends Person {
    private String name = "男人";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }

}