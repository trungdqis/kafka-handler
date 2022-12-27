package uit.trungdq.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import uit.trungdq.springboot.dto.OrderDTO;
import uit.trungdq.springboot.dto.OrderDetailDTO;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final KafkaTemplate<String, OrderDTO> kafkaTemplateOrder;
    private final KafkaTemplate<String, OrderDetailDTO> kafkaTemplateOrderDetail;

    public JsonKafkaProducer(KafkaTemplate<String, OrderDTO> kafkaTemplateOrder,
                             KafkaTemplate<String, OrderDetailDTO> kafkaTemplateOrderDetail) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
        this.kafkaTemplateOrderDetail = kafkaTemplateOrderDetail;
    }

    public void sendMessage(OrderDTO order) {
        LOGGER.info("Message sent -> {}", order.toString());

        Message<OrderDTO> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, "orders")
                .build();

        kafkaTemplateOrder.send(message);
    }

    public void sendMessage(OrderDetailDTO orderDetail) {
        LOGGER.info("Message sent -> {}", orderDetail.toString());

        Message<OrderDetailDTO> message = MessageBuilder
                .withPayload(orderDetail)
                .setHeader(KafkaHeaders.TOPIC, "order-detail")
                .build();

        kafkaTemplateOrderDetail.send(message);
    }
}
