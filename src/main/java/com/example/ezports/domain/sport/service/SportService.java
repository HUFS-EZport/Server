package com.example.ezports.domain.sport.service;

import com.example.ezports.domain.sport.converter.SportConverter;
import com.example.ezports.domain.sport.dto.SportRequestDTO;
import com.example.ezports.domain.sport.dto.SportResponseDTO;
import com.example.ezports.domain.sport.entity.Sport;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SportService {
    private final SportCommandService sportCommandService;
    private final SportQueryService sportQueryService;
    private final SportConverter sportConverter;

    @Transactional
    public SportResponseDTO.createSport createSport(SportRequestDTO.createSport request) {
        Sport sport = sportConverter.toSport(request.getName());
        Sport savedSport = sportCommandService.createSport(sport);
        return sportConverter.toCreateSport(savedSport);
    }

    @Transactional
    public List<SportResponseDTO.getSport> getSports() {
        List<Sport> sports = sportQueryService.getSports();
        return sportConverter.toGetSports(sports);
    }

    @Transactional
    public void updateSport(Long sportId, SportRequestDTO.updateSport request) {
        Sport sport = sportQueryService.getSport(sportId);
        sport.updateSport(request.getName());
    }

    @Transactional
    public void deleteSport(Long sportId) {
        Sport sport = sportQueryService.getSport(sportId);
        sportCommandService.deleteSport(sport);
    }
}
