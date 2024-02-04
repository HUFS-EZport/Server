package com.example.ezports.domain.sport.service;

import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.sport.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportCommandService {
    private final SportRepository sportRepository;

    public Sport createSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public void deleteSport(Sport sport) {
        sportRepository.delete(sport);
    }
}
