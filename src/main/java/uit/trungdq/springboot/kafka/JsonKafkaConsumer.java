package uit.trungdq.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import uit.trungdq.springboot.dto.OrderDTO;
import uit.trungdq.springboot.dto.OrderDetailDTO;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

   @KafkaListener(topics = "orders", groupId = "myGroup")
    public void consume(OrderDTO order) {
        LOGGER.info("Json message received -> {}", order.toString());
    }

//    @KafkaListener(topics = "orderDetail", groupId = "anotherGroup")
    public void consume(OrderDetailDTO orderDetail) {
        LOGGER.info("Json message received -> {}", orderDetail);
    }
}
