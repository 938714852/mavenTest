package com.ustc;

import com.ustc.beans.MyImportBeanDefinitionRegistrar;
import com.ustc.beans.MyImportSelector;
import com.ustc.beans.User;
import com.ustc.beans.Role;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

/**
 * @author : wtq
 * @date: 2022/10/30
 */
//用户标记一个spring配置类，之前根据xml启动spring上下文
//相当于xml文件<bean><bean/>
@Configurable
@ComponentScan(basePackages = "com.ustc") //<context:component-scan base-package="com.ustc"></context:component-scan>
@PropertySource("classpath:db.properties") // <context:property-placeholder location="db.properties"></context:property-placeholder>
@Import({SecondJavaConfig.class,Role.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
/**
 * @Import
 * 1、导入其他的配置类@Import(SecondJavaConfig.class)
 * 2、导入类注册为Bean，Import(Role.Class)，在Role上可不用@Component
 * 3、导入ImportSelector实现类，可以注册多个Bean，但getBean不能根据名字去获取，必须要根据类型获取
 * 4、导入MyImportBeanDefinitionRegistrar实现类，可以注册多个BeanDefinition，getBean可以使用名字和类型去获取
 */
public class IocJavaConfig {
    /**
     * @Bean可以将一个类的实例（可以干预Bean的实例化过程），注册为一个bean
     * 会自动将返回值作为Bean的类型  将方法名作为Bean的id
     * @Bean(name="data","dd")设置Bean的id及别名（替换）
     * 怎么去自动配置一个外部Bean：直接在方法里面写上需要依赖的参数即可，不需要写@Autowired
     * 怎么去自动配置一个内部Bean：直接调用方法即可
     *
     */

    @Bean
    public User user(Role role){
        System.out.println("user()");
        // 注册到spring ioc 容器中。
        // ioc容器=map   bean definitionMap <key, value>  -> key : beanName, value : beanClass
        // map  -> (user , com.ustc.beans.User)
        // map  -> (user2 , com.ustc.beans.User)
        // bean -> 获取到这个类的构造器， 选择构造器， -> 反射类对象（new）（属性是没有赋值）-> 依赖注入（@Resource @Autowird @Value）
        //      -> 类快成为一个成品bean
        //      -> AOP
        //      -> 加入到spring容器中去。
        // -> 成品bean就是可以从Spring容器中getBean()出来bean
        User user = new User();
        user.setName("123");
        user.setSqlName("123");
        System.out.println(role.getName());
        return user;
    }





}
