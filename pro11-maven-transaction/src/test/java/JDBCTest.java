import com.alibaba.druid.pool.DruidDataSource;
import com.ustc.maven.dao.IUserDao;
import com.ustc.maven.entity.User;
import com.ustc.maven.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Miracle
 * @date 2023/2/15 15:30
 * @description JDBCTest
 */
public class JDBCTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("classpath:spring.xml");

    }
    @Test
    public void test1(){
        DruidDataSource druidDataSource = ioc.getBean(DruidDataSource.class);
        System.out.println(druidDataSource);
    }

    /**
     * JdbcTemplate 演示
     */

    @Test
    public void test2(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        //查询单个值
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println(aLong);
    }
    @Test
    public void test3(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        //查询实体
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println(aLong);

    }
    @Test
    public void test4(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        //查询数据库字段和属性名一样，利用BeanPropertyRowMapper
        //User user = jdbcTemplate.queryForObject("select * from t_user where id = 1", new BeanPropertyRowMapper<>(User.class));//根据User类型自动做映射
//        User user = jdbcTemplate.queryForObject("select * from t_user where id = 1",
//                (resultSet,i)->{
//                    User o = new User();
//                    o.setId(resultSet.getInt("id"));
//                    o.setUsername(resultSet.getString("username"));
//                    return o;
//                });     //lambda表达式，更简洁
        User user = jdbcTemplate.queryForObject("select * from t_user where id = 1", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user1 = new User();
                user1.setId(rs.getInt("id"));
                return user1;
            }
        });
        System.out.println(user);
    }
    @Test
    public void test5(){
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String roll = String.valueOf((int)(Math.random()*100));
        //查询实体
        int result = jdbcTemplate.update("insert into t_user(username,cardno,balance) values (?,?,?)", "插入" + roll,"1234",123);
        System.out.println(result + "加入的名字是" + roll + "号");
    }

    /**
     * 具体名字参数 NamedParameterJdbcTemplate
     */
    @Test
    public void test6(){
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
        Map<String , Object> map = new HashMap<>();
        map.put("id",4);
        int result = jdbcTemplate.update("delete from t_user where id=:id",map);
        System.out.println(result);
    }

    @Test
    public void test7(){
        IUserService userService = ioc.getBean(IUserService.class);
        System.out.println(userService.getUser());
    }
}
