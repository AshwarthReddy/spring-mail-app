package com.anr.mail.service;

import jakarta.mail.MessagingException;

public interface MailSenderService {

    String sendEmail(String mailID, String subject, String message);

    String sendEmailWithAttachment(String mailID, String subject, String message, Boolean isAttachment) throws MessagingException;

}
