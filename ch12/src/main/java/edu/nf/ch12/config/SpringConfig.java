package edu.nf.ch12.config;

import edu.nf.ch12.controller.UserController;
import edu.nf.ch12.dao.UserDao;
import edu.nf.ch12.dao.impl.UserDaoImpl;
import edu.nf.ch12.service.UserService;
import edu.nf.ch12.service.impl.StuServiceImpl;
import edu.nf.ch12.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * @author 洒度
 * @date 2020/12/4
 */
@Configuration
public class SpringConfig {
    /**
     * 使用@Bean注解来装配
     * 方法名默认就是bean的ID
     * 也可以通过name属性重新定义
     */
    @Bean(name = "dao",initMethod = "init",destroyMethod = "destroy")
    //@Scope注解也可以声明在方法上
    //@Primary注解也可以标注在方法上，表示优先注入这个bean
//    @Primary
    @Scope("singleton")
    public UserDaoImpl userDao(){
        return new UserDaoImpl();
    }

    /**
     * 装配service
     * @return
     */
    @Bean(name = "Userservice")
    public UserServiceImpl userService(UserDao userDao){
        UserServiceImpl service= new UserServiceImpl();
        //手动调用set方法进行注入
        //方式一：调用userDao的方法获取dao的bean进行注入
//        service.setUserDao(userDao());
        //方式二：通过Spring传进来的参数进行注入
        service.setUserDao(userDao);
        return service;
    }

    /**
     * 装配Controller
     * 当有多个实现类时，会先根据参数的变量名称作为ID到容器中查找
     * 如果找到则直接传入进来注入，找不到则引发异常。
     * 因此可以结合@Qualifier
     * @param service
     * @return
     */
    @Bean
    public UserController userController(@Qualifier("stuService") UserService service){
        UserController controller=new UserController();
        //注入UserService
        controller.setUserService(service);
        return controller;
    }

    /**
     * 装配StuService
     * @param userDao
     * @return
     */
    @Bean
    public StuServiceImpl stuService(UserDao userDao){
        StuServiceImpl service=new StuServiceImpl();
        service.setUserDao(userDao);
        return service;
    }
}
