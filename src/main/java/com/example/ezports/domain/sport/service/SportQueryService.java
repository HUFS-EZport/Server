package com.example.ezports.domain.sport.service;

import com.example.ezports.domain.sport.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportQueryService {
    private final SportRepository sportRepository;
}
