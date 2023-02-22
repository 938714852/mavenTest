package com.ustc.maven;

import com.ustc.maven.mapper.EmpMapper;
import com.ustc.maven.pojo.Emp;
import com.ustc.maven.pojo.QueryEmpDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
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


    @Test
    public void test01() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            QueryEmpDTO queryEmpDTO = new QueryEmpDTO();
            queryEmpDTO.setId(1);
            List<Emp> emps = mapper.QueryEmp(queryEmpDTO);
            System.out.println(emps);
        }
    }
    /**
     * if
     * where
     * trim
     */
    @Test
    public void test02() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Mybatis在getMapper就会给我们创建jdk动态代理
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            QueryEmpDTO dto = new QueryEmpDTO();
            dto.setDid(0);
            List<Emp> emps = mapper.QueryEmp(dto);
            System.out.println(emps);

        }
    }

    /**
     * choose when otherwise
     */
    @Test
    public void test03() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Mybatis在getMapper就会给我们创建jdk动态代理
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            List<Emp> emps = mapper.QueryEmp2("经理");
            System.out.println(emps);

        }
    }

    /**
     * foreach
     */
    @Test
    public void test04() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Mybatis在getMapper就会给我们创建jdk动态代理
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            List<Emp> emps = mapper.QueryEmp3(new String[]{"wtq", "www"});
            System.out.println(emps);

        }
    }
    /**
     * bind
     */
    @Test
    public void test05() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Mybatis在getMapper就会给我们创建jdk动态代理
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            List<Emp> emps = mapper.QueryEmp4("w");
            System.out.println(emps);

        }
    }
    /**
     * 批量插入
     *  1. 循环逐条插入 1753ms
     *  2. ExecutorType.BATCH 478ms
     *  3. mysql的批量sql插入 417ms
     */
    @Test
    public void test06() {
        // 准备1000条Emp数据
        List<Emp> list=new ArrayList<>();
        for (int i=0;i<1000;i++){
            list.add(new Emp(null,"ceshi"+i, LocalDate.now(),2));
        }

        long begin = System.currentTimeMillis();
        // try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Mybatis在getMapper就会给我们创建jdk动态代理
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            // System.out.println(mapper.insert(emp));
            System.out.println(mapper.inserBatch(list));
            sqlSession.commit();

        }
        long end = System.currentTimeMillis();

        System.out.println(end-begin+"ms");
    }

}
