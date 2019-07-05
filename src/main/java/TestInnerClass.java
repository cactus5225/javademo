import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Created by xufei on 2019/4/9.
 */
public class TestInnerClass implements Serializable {
    private static final long serialVersionUID = 2010307013874058143L;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public C1 c1;
    public C1 getC1() {
        return c1;
    }
    public void setC1(C1 c1) {
        this.c1 = c1;
    }
    public class C1 {
        public String name;
        public C1() {
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }



    public static void main(String[] args) throws Exception{
//        //阿里的fastjson 可以兼容非静态的内部类序列化
//        TestInnerClass test = new TestInnerClass();
//        System.out.println(JSON.toJSON(test));
//        String json = "{\"name\":\"test\",\"c1\":{\"name\":\"c1\"}}";
//        System.out.println(json);
//        test = JSON.parseObject(json, TestInnerClass.class);
//        System.out.println(test.getC1().getName());

        String filePath = System.getProperty("user.dir")+"/src/main/resources/innerclass.txt";
        File file = new File(filePath);
        // 序列化
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        TestInnerClass test = new TestInnerClass();
        test.setName("aaaa");
        oout.writeObject(test);
        oout.close();
        // 反序列化
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();
        oin.close();
        System.out.println(newPerson);
    }
}
