
import com.ustc.maven.mapper.EmpMapper;
import com.ustc.maven.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Miracle
 * @date 2023/2/20 10:16
 * @description MybatisTest
 */
public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    Logger LOGGING = LoggerFactory.getLogger(this.getClass());

    @Before
    public void before() throws IOException {
        // 根据全局配置文件的xml构建成 sqlSessionFactory
        String resource = "mybatis-config.xml";
        // 将xml构建成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 建成 sqlSessionFactory : 将全局配置文件和所有的mapper全部加载到Configuration里
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 使用了工厂和构造器设计模式
    }

    @Test
    public void test01() {
        // SqlSession 执行具体的数据库操作
        /**
         * 默认的 openSession() 方法没有参数，它会创建具备如下特性的 SqlSession：
         * 给 openSession() 设置不同的参数会给SqlSession后续的数据库操作造成不同的影响
         * boolean autoCommit : 事务作用域将会开启（也就是不自动提交）,可以设置例如增删改后的自动commit。
         * Connection connection : 将由当前环境配置的 DataSource 实例中获取 Connection 对象。
         * TransactionIsolationLevel level : 事务隔离级别将会使用驱动或数据源的默认设置。
         * ExecutorType execType : 预处理语句是否复用，是否批量处理更新。 sql语句是否运行每次都会进行预处理，非动态sql可以设置只预处理一次
         */
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // USTC mybatis在getMapper就会给我们创建jdk动态代理  底层动态代理
            EmpMapper mapper = session.getMapper(EmpMapper.class);
            Emp emp = mapper.selectEmp(1);
            System.out.println(emp);
        }
    }

    /**
     *  日志级别
     *  TRACE < DEBUG < INFO < WARN < ERROR
     *    1       2       3     4      5
     *  日志级别低的可以输出级别高的
     */
    @Test
    public void test02() {
        LOGGING.trace("跟踪级别");
        LOGGING.debug("调试级别");
        LOGGING.info("信息级别");
        LOGGING.warn("警告级别");
        LOGGING.error("异常级别");

    }


}
