package com.rodrigosousa.oraclecloud_microservice.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void sendReport(String content, String to){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            int currentDate = new Date().getMonth() + 1;

            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject("Monthly Report - " + currentDate);
            helper.setTo(to);
            javaMailSender.send(message);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
