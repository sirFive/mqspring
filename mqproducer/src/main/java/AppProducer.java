import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate)context.getBean("rabbitTemplate");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xie");
        map.put("age", 28);
        //根据key发送到对应的队列
        rabbitTemplate.convertAndSend("que_xie_key", map);

        map.put("name", "yang");
        map.put("age", 27);
        //根据key发送到对应的队列
        //rabbitTemplate.convertAndSend("que_xie_key", map); 也是有XieHandler处理
        rabbitTemplate.convertAndSend("que_yang_key", map);
        context.close();
    }
}
