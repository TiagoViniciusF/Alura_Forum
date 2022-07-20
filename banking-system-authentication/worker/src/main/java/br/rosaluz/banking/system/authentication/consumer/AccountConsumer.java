package br.rosaluz.banking.system.authentication.consumer;

import br.rosaluz.banking.system.authentication.consumer.dto.AccountConsumerMenssageDTO;
import br.rosaluz.banking.system.authentication.processor.UserAccountProcessor;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

@AllArgsConstructor
public class AccountConsumer {

    private static final Logger log = LoggerFactory.getLogger(AccountConsumer.class);

    @Value(value = "${topic.consumer.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    private UserAccountProcessor userAccountProcessor;

    @KafkaListener(topics = "${topic.consumer.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transferKafkaListenerContainerFactory")
    public void listenTopicAccount(ConsumerRecord<String, AccountConsumerMenssageDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());

        userAccountProcessor.process(record.value().toString());

    }
}
