package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailCodeRepository emailCodeRepository;
}
