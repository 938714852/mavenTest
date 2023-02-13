import com.ustc.maven.Calculator;
import com.ustc.maven.ICalculator;
import com.ustc.maven.MyProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Miracle
 * @date 2023/2/13 17:33
 * @description ProxyTest
 */
/**
 * 使用jdk动态代理完成增加日志功能：动态生成代理类
 */
public class ProxyTest {
    @Test
    public void test1(){
        /**
         * ClassLoader loader 类加载器 ，通常指定的被代理类的接口的类加载器
         * Class<?>[] interfaces. 类型， 通常制定被代理类的接口的类型
         * invocationHandler h 委托执行的处理类：日志功能
         */
        ClassLoader classLoader = ICalculator.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{ICalculator.class};
        InvocationHandler handler = new InvocationHandler() {
            //被代理的对象
            Object target = new Calculator();
            //代理类的执行方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志：调用的方法，参数是：" + Arrays.asList(args));
                //执行被代理的方法
                /**
                 * 2个参数
                 * Object obj 被代理的对象
                 * Object ... args 被代理的方法参数，直接将args传进去
                 *
                 */
                Object result = method.invoke(target, args);
                System.out.println("日志：" + result);
                return result;
            }
        };
        //动态创建代理类
        ICalculator o = (ICalculator) Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());
        System.out.println(o.add(1, 1));

    }
    @Test
    public void test2(){
        ICalculator proxy = (ICalculator) MyProxy.createProxy(new Calculator());
        proxy.div(4,2);
    }
}
