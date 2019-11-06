import java.io.InputStream;

/**
 * Created by xufei on 2019/9/16.
 * 类的全限定名+同一个类加载器才能确定是同一个类。
 * 否则instance of 方法返回的是false.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myClassLoad = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = null;
                    fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte [] b = new byte[is.available()];

                    is.read(b);
                    return  defineClass(name,b,0,b.length);
                } catch (Exception e) {
                    throw  new ClassNotFoundException(name);
                }


            }
        };

        Object object =myClassLoad.loadClass("ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof ClassLoaderTest);


   }
}
