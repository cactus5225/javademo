import java.util.HashSet;
import java.util.Set;

/**
 * Created by xufei on 2019/4/8.
 */
public class Stu implements  Cloneable{
    private String name;
    private int age;

    Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj.getClass() != getClass()){
            return false;
        }
        return ((Stu)obj).getName().equals(getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        Stu s1 = new Stu("张三", 18);
        Stu s2 = new Stu("张三", 18);
        System.out.println("stu:" + s1.equals(s2));

        Set<Stu> set = new HashSet<>();
        set.add(s1);
        System.out.println("s1 hashCode:" + s1.hashCode());
        System.out.println("add s1 size:" + set.size());
        set.add(s2);
        System.out.println("s2 hashCode:" + s2.hashCode());
        System.out.println("add s2 size::" + set.size());

    }
}
