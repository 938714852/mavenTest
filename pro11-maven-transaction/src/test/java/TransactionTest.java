import com.alibaba.druid.pool.DruidDataSource;
import com.ustc.maven.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Miracle
 * @date 2023/2/18 10:34
 * @description TransactionTest
 */
public class TransactionTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("classpath:spring.xml");

    }
    @Test
    public void test1(){
        IUserService userService = ioc.getBean(IUserService.class);
        userService.trans();
    }
}
