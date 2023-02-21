import com.ustc.maven.mapper.EmpMapper2;
import com.ustc.maven.mapper.Empmapper;
import com.ustc.maven.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Miracle
 * @date 2023/2/19 19:33
 * @description Test
 */

/**
 * Mybatis搭建步骤
 * 1.添加pom依赖（mybatis的核心jar包和数据库对应版本的驱动jar包）
 * 2.添加mybatis全局配置文件 mybatis-config.xml（可以从官网复制）
 * 3.修改全局配置文件中的 数据源配置信息
 * 4.添加数据库表对应的POJO对象（相当于我们以前的实体类）
 * 5.添加对应的PojoMapper.xml（里面维护所有的sql）
 *      修改namespace：如果是StatementId 没有特殊要求
 *                    如果是接口绑定的方式必须等于接口的完整限定名
 *      修改对应的id（唯一）、resultType 对应返回的类型如果是Pojo 需要制定完整限定名
 * 6.修改mybatis全局配置文件：修改mapper
 */
public class Test1 {
    /**
     * 基于statementId的方式去执行sql
     *       <mapper resource="EmpMapper.xml"/>
     * @throws IOException
     */
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test01() {
        // 从XML中构建 SqlSessionFactory
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Emp emp = (Emp) session.selectOne("org.mybatis.example.EmpMapper.selectEmp", 1);
            System.out.println(emp);
        }
    }

    /**
     * USTC 不使用注解的方式更有利于后期维护，实现了sql和java代码的解耦，推荐使用
     * 基于接口绑定的方式
     * 1.新建数据访问层的接口： POJOMapper
     * 2.添加 mapper中对应的操作的方法
     *      1.方法名要和mapper中对应的操作的节点id要一致
     *      2.返回类型要和mapper中对应的操作的节点的resultType要一致
     *      3.mapper中对应的操作的节点的参数必须要在方法的参数中声明
     * 3.Mapper.xml 中的namespace必要要和接口中的完整限定名一致
     * 4.修改Mybatis全局配置文件中的mappers，采用接口绑定的方式：
     *      <mapper class="com.ustc.maven.mapper.Empmapper"></mapper>
     * 5.一定要将mapper.xml和接口放在同一级目录中，如果用的maven，只需要在resources新建和接口同样结构的文件夹就行了，生成就会合并在一起
     * @throws IOException
     */
    @Test
    public void test02()  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Empmapper mapper = session.getMapper(Empmapper.class);
            Emp emp = mapper.selectEmp(1);
            System.out.println(emp);
        }
    }

    /**
     *基于注解的方式
     * 注意：
     *      注解可以和xml共用，但是不能同时存在方法对应的xml的id
     */
    @Test
    public void test03()  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpMapper2 mapper = session.getMapper(EmpMapper2.class);
            Emp emp = mapper.selectEmp(1);
            System.out.println(emp);
        }
    }
}
