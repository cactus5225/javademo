/**
 * Created by xufei on 2019/4/9.
 */
public class Book implements Cloneable {
    private int id;

    private String name;

    private Stu stu;

    public Book() {
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            Book book =(Book) super.clone();
            book.stu = (Stu)this.stu.clone();
            return book;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 实则浅拷贝和深拷贝只是相对的，如果一个对象内部只有基本数据类型，那用 clone() 方法获取到的就是这个对象的深拷贝，
     * 而如果其内部还有引用数据类型，那用 clone() 方法就是一次浅拷贝的操作。
     *
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book();
        book1.stu = new Stu("aaa",18);
        book1.setName("基础系列1");
        //
        Book book2 = (Book) book1.clone();

        System.out.println("对象中的引用类型的成员变量现在是否是深拷贝");
        System.out.println(book1.stu == book2.stu);


        System.out.println("未重写equal方法");
        System.out.println(book1.equals(book2));
        //hascode不同说明不是传递引用，而是新建了一个对象，将对象里的成员变量的值赋值过去。
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());

        System.out.println("图书1:" + book1.getName());
        System.out.println("图书2:" + book2.getName());

        book2.setName("基础系列2");

        System.out.println("图书1:" + book1.getName());
        System.out.println("图书2:" + book2.getName());





    }


}
