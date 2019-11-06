package DesignPatterns.VisitorMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufei on 2019/10/10.
 */
public class ObjectStructure {
    private List<Person> elements = new ArrayList<Person>();

    public void attach(Person person) {
        elements.add(person);
    }

    public void detach(Person person) {
        elements.remove(person);
    }

    public void display(Action visitor) {
        for (Person e : elements) {
            e.accept(visitor);
        }
    }
}
