package com.ustc;

import com.ustc.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : wtq
 * @date: 2022/10/30
 */
@Component
public class SecondJavaConfig {
    @Bean
    public User user2() {
        System.out.println("user2()");
        return new User();
    }
    // Meta- 1. 加载beanClass -> resolveBeanClass() -> 通过beanClass返回一个Class对象。
    // Meta- 2. 实例化前 -> 第一次调用BeanPostProcessor（这里也有可能是两次调用）（实例化前）
    // 			(1). InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation()
    // 			 	-> 可以通过此扩展点 将beanClass转换成自定义的Class类型的Bean (自定义bean的实例化)
    //  			如果在第一次调用返回了bean实例，则Spring认为已经完成了bean的实例化，则调用（2）的后置处理器。
    // 			(1.1). BeanPostProcessor.postProcessAfterInitialization()
    //  				-> 直接跳到初始化后这一步 与AOP有关。 所有的bean都必须走到AOP逻辑，
    // Meta- 3. 实例化bean -> doCreateBean() -> 实例化bean，在createBeanInstance()中推断实例化的构造方法。
    // 				-> 会处理@Bean逻辑、@Autowired
    //  			-> 第二次调用BeanPostProcessor（推断构造方法时）
    // 			(2). SmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors()
    // 				-> AutowiredAnnotationBeanPostProcessor.determineCandidateConstructors()
    // 				-> 处理被@Autowired注解的构造方法
    //  			-> 第三次调用BeanPostProcessor （实例化时）
    //  		(3). MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition()
    //  			-> 通过此扩展点可以对合并之后的BeanDefinition进行自定义设置部分属性值。（有些在加载类设置过的值不能修改。）
    // Meta- 4. 实例化bean之后 -> populateBean()
    //  			-> 第四次调用BeanPostProcessor （实例化bean之后，属性赋值之前。）
    //  		(4). InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation()
    //  			-> 这是在给定 bean 实例上执行自定义字段注入的理想回调，就在 Spring 的自动装配开始之前。
    // Meta- 5. 属性填充前 -> populateBean() -> Spring自带的依赖注入处理。
    // Meta- 6. 属性填充时 -> Spring自带的依赖注入处理结束之后； 依据autowire = Autowire.BY_NAME / BY_TYPE (已过时)！
    //  			-> 第五次调用BeanPostProcessor（在属性填充时，自带依赖注入处理之后，）
    //  		(5). InstantiationAwareBeanPostProcessor.postProcessProperties()
    //  			-> postProcessProperties() 尤其重要，这里会用来处理@Autowired、@Resource、@Value注解。
    //  				-> InstantiationAwareBeanPostProcessor在Spring中有默认实现类AutowiredAnnotationBeanPostProcessor
    //  				-> 也可以自定义实现，用以来处理自定义的注解。
    //  			-> 第六次调用BeanPostProcessor（在处理循环依赖时）
    // 			(6). AbstractAutoProxyCreator.getEarlyBeanReference()
    // 				-> 三级缓存存储执行逻辑，发生循环依赖调用， 如需要AOP的bean提前进行AOP并保存。
    //				-> wikr-@see AbstractAutoProxyCreator#getEarlyBeanReference 处理循环依赖逻辑
    // Meta- 7. bean的初始化之前 -> initializeBean() -> 回调BeanNameAware 、BeanClassLoaderAware、 BeanFactoryAware 设置属性
    //  			-> 第七次调用BeanPostProcessor （在bean的初始化之前）
    //  		(7). BeanPostProcessor.postProcessBeforeInitialization();
    //  			-> 其中一个实现类：InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization()
    // 				-> 会去处理@PostConstruct注解的方法（但是这里不会调用）
    //  			-> ApplicationContextAwareProcessor.postProcessBeforeInitialization()这个实现类，
    // 				-> 会去判断各种Aware， 符合在按照类型去回调Aware。
    // Meta- 8. bean的初始化 -> invokeInitMethods()
    // 				-> 在bean初始化的时候 会去判断是bean是否是 InitializingBean 类型，（扩展点）
    // 					-> 是则会去循环调用 InitializingBean#afterPropertiesSet()。 可以自定义扩展在初始化时的操作。
    //  				-> 在调用完上述方法之后， 会去处理InitMethods,也就是初始化方法（如果自己有指定init() 会在此处调用。）
    // 					-> 在第三次调用的BeanPostProcessor的时候 获取到的beanDefinition中就可以设置initMethods。
    // Meta- 9.	bean的初始化后 -> 存入单例池，（循环依赖问题。） AOP
    //  			-> 第八次调用BeanPostProcessor （bean初始化后）
    //  		(8). BeanPostProcessor.postProcessAfterInitialization()  --> AOP逻辑处理、Async异步调用逻辑处理
    //				-> wikr-@see AbstractAutoProxyCreator#postProcessAfterInitialization 处理AOP逻辑。
    // Meta- 10. bean的销毁准备。（doClose()方法） -> AbstractBeanFactory#registerDisposableBeanIfNecessary
    //  					-> 将所有实现销毁接口 DisposableBean 、销毁注解 (@PreDestroy)方法的bean放到map中 等待调用context.close()方法是调用。
    //  		  -> 第九次调用BeanPostProcessor （在bean的销毁准备）
    //  		(9). DestructionAwareBeanPostProcessor.requiresDestruction() 判断一个bean是否需要销毁。自定义销毁逻辑
    //  			-> InitDestroyAnnotationBeanPostProcessor同时这里处理@PreDestroy注解。
    //  			->
    // Meta- 11. bean的销毁 -> AbstractApplicationContext.close() bean的销毁，单例池中的bean直接清除，如果在待执行销毁方法的beanMap中 则遍历调用销毁逻辑。
    // 			  -> 第十次调用 BeanPostProcessor （在bean的销毁之前。）
    // 			(10). DestructionAwareBeanPostProcessor.postProcessBeforeDestruction() 处理自定义的bean销毁逻辑。
}
