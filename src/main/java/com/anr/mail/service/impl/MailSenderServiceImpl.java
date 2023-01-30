package com.anr.mail.service.impl;

import com.anr.mail.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
}
