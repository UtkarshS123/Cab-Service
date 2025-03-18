package com.cab.consumer.reciver;

import com.cab.common.kafka.MailTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final JavaMailSender mailSender;

    public ConsumerService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics ="SENDER", groupId = "cab-service")
    public void listner(MailTemplate mailTamplet){
       sendEmail(mailTamplet.mailId(), mailTamplet.subject(), mailTamplet.message());
        System.out.println("Print message " + mailTamplet.message());
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("noreply@example.com");

        mailSender.send(message);
        System.out.println("Email Sent to: " + to);
    }

}
