package com.anr.mail.controller;

import com.anr.mail.service.MailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail-controller")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @GetMapping("/{mailId}/{subject}/{message}")
    public String sendEmail(@PathVariable String mailId, @PathVariable String subject,@PathVariable String message){
        return mailSenderService.sendEmail(mailId, subject, message);
    }
    @GetMapping("/{mailId}/{subject}/{message}/{attachment}")
    public String sendEmailAttachment(@PathVariable String mailId, @PathVariable String subject,@PathVariable String message,
                                      Boolean isAttachment) throws MessagingException {
        return mailSenderService.sendEmailWithAttachment(mailId, subject, message, isAttachment);
    }
}
