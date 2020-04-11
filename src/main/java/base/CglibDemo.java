package base;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.*;
import org.junit.Test;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;

import static junit.framework.Assert.assertEquals;

/**
 * Created by xufei on 2020/4/11.
 * cglib既可以代理接口也可以代理类
 * 可以判断方法的类型，对指定的方法进行拦截
 */
public class CglibDemo {
    public String test() {
        return "hello wold";
//        System.out.println("hello world");
    }

    public void sayHello() {
        System.out.println("test test");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibDemo.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });

        CglibDemo sample = (CglibDemo) enhancer.create();
        sample.test();
        sample.sayHello();
        sample.getClass();
        System.out.println(sample.hashCode());
    }


    @Test
    public void testCallbackFilter() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(CglibDemo.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            System.out.println("Hello cglib");
                            return "Hello cglib";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(CglibDemo.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        CglibDemo proxy = (CglibDemo) enhancer.create();
        System.out.println(proxy.hashCode());
        proxy.test();
    }


    /**
     * 运行时动态的生成类
     *
     * @throws Exception
     */
    @Test
    public void testBeanGenerator() throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        assertEquals("Hello cglib", getter.invoke(myBean));
    }


    /**
     * 动态的生成接口
     *
     * @throws Exception
     */
    @Test
    public void testInterfaceMarker() throws Exception {
        Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(signature, new Type[0]);
        Class iface = interfaceMaker.create();
        assertEquals(1, iface.getMethods().length);
        assertEquals("foo", iface.getMethods()[0].getName());
        assertEquals(double.class, iface.getMethods()[0].getReturnType());
    }


}