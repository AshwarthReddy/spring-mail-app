package com.anr.mail.service.impl;

import com.anr.mail.service.MailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImpl implements MailSenderService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(String mailID, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailID);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
        return "MAIL SENT SUCCESSFULLY";
    }

    @Override
    public String sendEmailWithAttachment(String mailID, String subject, String message, Boolean isAttachment) throws MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(mailID);

        helper.setSubject(subject);

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("my_photo.png", new ClassPathResource("Gmail_logo.png"));

        javaMailSender.send(msg);
        return "MAIL SENT SUCCESSFULLY WITH ATTACHMENT";
    }
}
