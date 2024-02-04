package com.example.ezports.domain.sport.service;

import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.sport.repository.SportRepository;
import com.example.ezports.global.exception.GeneralException;
import com.example.ezports.global.exception.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportQueryService {
    private final SportRepository sportRepository;

    public Sport getSport(Long sportId) {
        return sportRepository.findById(sportId)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.SPORT_NOT_FOUND));
    }
    public List<Sport> getSports() {
        return sportRepository.findAll();
    }
}
