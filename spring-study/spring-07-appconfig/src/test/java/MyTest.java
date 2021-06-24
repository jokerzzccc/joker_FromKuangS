import com.joker.config.JokerConfig;
import com.joker.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //如果按照配置类的方式去做，就只能通过，AnnotationConfig 上下文来获取容器，通过配置类的class对象来加载
        ApplicationContext context = new AnnotationConfigApplicationContext(JokerConfig.class);
        User getUser =(User) context.getBean("getUser");
        System.out.println(getUser.getName());

    }
}
