package com.cab.producer.sender;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.cab.common.kafka.MailTemplate;

@Service
public class ProducerService {

    private final KafkaTemplate<String, MailTemplate> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, MailTemplate> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        MailTemplate mailTamplet= new MailTemplate("test@example.com", "Testing kafka with mail", message);
        kafkaTemplate.send("SENDER", mailTamplet);
        System.out.println("Sending message");
    }
}
