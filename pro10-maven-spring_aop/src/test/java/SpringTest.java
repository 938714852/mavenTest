import com.ustc.maven.entity.User;
import com.ustc.maven.service.IUserService;
import com.ustc.maven.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Miracle
 * @date 2023/2/14 11:56
 * @description SpringTest
 */
public class SpringTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/spring.xml");
        //UserServiceImpl bean = ioc.getBean(UserServiceImpl.class);
        // 被代理后，是以aop代理后的类存在ioc容器中，所以不能用UserServiceImpl来申明
        IUserService bean = ioc.getBean(IUserService.class);
        bean.add(new User());
        bean.select(2);
        bean.select(null);

        System.out.println(bean.getClass());
        //在没有aop的情况下：class com.ustc.maven.service.impl.UserServiceImpl
        //当使用了aop的情况下:
        //  class com.sun.proxy.$Proxy19
        //      JDK代理所产生一个动态代理类，当被代理的类使用了接口，默认使用jdk代理
        //  class com.ustc.maven.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$8852e3af
        //      cglib代理所产生一个动态代理类，当被代理的类没有使用了接口，使用cglib代理


    }
}
