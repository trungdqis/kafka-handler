package uit.trungdq.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

   @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("orders")
                .build();
    }

   @Bean
    public NewTopic orderDetailTopic() {
        return TopicBuilder.name("order-detail")
                .build();
    }
}
