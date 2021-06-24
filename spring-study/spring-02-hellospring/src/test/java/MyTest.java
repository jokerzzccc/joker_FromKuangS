import com.joker.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象 ApplicationContext :拿到Spring的容器
        //即，对象都在Spring中管理 了，要用可以直接去取
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello =(Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
