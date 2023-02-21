
import com.ustc.maven.mapper.DeptMapper;
import com.ustc.maven.mapper.EmpMapper;
import com.ustc.maven.pojo.DeptEmpDTO;
import com.ustc.maven.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class MyBatisTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() {

        // 根据全局配置文件的xml构建成SqlSessionFactory
        String config = "mybatis-config.xml";
        // 将xml构建成输入流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建SqlSessionFactory :将全局配置文件和所有的mapper全部加载到Configuration
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 多对一
     */
    @Test
    public void test01() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            System.out.println(mapper.selectEmpAndDept());
        }
    }

    /**
     * 一对多
     */
    @Test
    public void test02() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            List<DeptEmpDTO> deptEmpDTOS = mapper.selectDeptAndEmps();
            System.out.println(deptEmpDTOS);
        }
    }

}
