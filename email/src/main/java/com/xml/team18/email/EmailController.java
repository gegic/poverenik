package com.xml.team18.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/api/email", consumes = MediaType.APPLICATION_XML_VALUE)
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping
    public ResponseEntity<Void> sendMail(@RequestBody EmailDto email) {
        emailService.sendSimpleMessage(email.getTo(), email.getSubject(), email.getContent());
        return ResponseEntity.ok().build();
    }

}
