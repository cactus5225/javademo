import java.io.*;

/**
 * Created by xufei on 2019/4/9.
 */
public class Person implements Serializable ,Cloneable{
    private static final long serialVersionUID = 2L;

    private String name;
    private Integer age;
    private String address;
    private String email;



    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, Integer age, String address,String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception{
            File file = new File("/Users/xufei/demo/src/main/resources/person.out");
            // 序列化
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
            Person person = new Person("John", 21, "广州");
            oout.writeObject(person);
            oout.close();
            // 反序列化
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            Object newPerson = oin.readObject();
            oin.close();
            System.out.println(newPerson);



    }


}
