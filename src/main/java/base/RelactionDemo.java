package base;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by xufei on 2020/4/11.
 * 反射
 * 静态编译：在编译时确定类型，绑定对象
 * 动态编译：运行时确定类型，绑定对象，支持多态
 * <p>
 * <p>
 * 使用场景
 * <一> jdbc注册驱动
 * <二>spring读取xml生成类
 * 将程序内所有 XML 或 Properties 配置文件加载入内存中
 * Java类里面解析xml或properties里面的内容，得到对应实体类的字节码字符串以及相关的属性信息
 * 使用反射机制，根据这个字符串获得某个类的Class实例
 * 动态配置实例的属性
 */
public class RelactionDemo {
    //驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR 包中
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    public static final String DBURL = "jdbc:mysql://localhost:3306/test";
    //连接数据库的用户名
    public static final String DBUSER = "root";
    //连接数据库的密码
    public static final String DBPASS = "";


    @Test
    public void dbConnectionJDBC() throws Exception {
        Connection con = null; //表示数据库的连接对象
        Class.forName(DBDRIVER); //1、使用CLASS 类加载驱动程序 ,反射机制的体现
        con = DriverManager.getConnection(DBURL, DBUSER, DBPASS); //2、连接数据库
        System.out.println(con);
        con.close(); // 3、关闭数据库
    }
}
