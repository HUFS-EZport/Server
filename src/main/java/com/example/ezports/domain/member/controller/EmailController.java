package com.example.ezports.domain.member.controller;

import com.example.ezports.domain.member.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/email")
@RequiredArgsConstructor
public class EmailController {
    private EmailService emailService;
}
