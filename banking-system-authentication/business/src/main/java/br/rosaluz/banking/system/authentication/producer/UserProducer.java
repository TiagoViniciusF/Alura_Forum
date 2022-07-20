package br.rosaluz.banking.system.authentication.producer;

import br.rosaluz.banking.system.authentication.model.User;
import br.rosaluz.banking.system.authentication.producer.dto.UserMessageDTO;
import br.rosaluz.banking.system.authentication.producer.dto.converter.UserToUserMessageDTO;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
    private final String topic;
    private final KafkaTemplate<String, UserMessageDTO> kafkaTemplate;

    public UserProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, UserMessageDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(User user) {
        var transferMessageDTO = UserToUserMessageDTO.convert(user);
        kafkaTemplate.send(topic, transferMessageDTO).addCallback(
                success -> logger.info("Messagem send" + success.getProducerRecord().value()),
                failure -> logger.info("Message failure" + failure.getMessage())
        );
    }
}
