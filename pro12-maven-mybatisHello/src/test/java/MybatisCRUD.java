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
 * @date 2023/2/19 20:55
 * @description MybatisCRUD
 */
public class MybatisCRUD {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void select() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Empmapper mapper = session.getMapper(Empmapper.class);
            Emp emp = mapper.selectEmp(1);
            System.out.println(emp);
        }
    }

    /**
     * 添加
     *      注意：提交事务
     */
    @Test
    public void insert() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Empmapper mapper = session.getMapper(Empmapper.class);
            Emp emp = new Emp();
            emp.setName("www");
            mapper.insertEmp(emp);
            System.out.println(mapper.selectEmp(3));
            session.commit();
        }
    }

}
