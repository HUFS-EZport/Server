package com.example.ezports.domain.mapping.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.mapping.entity.Participant;
import com.example.ezports.domain.mapping.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Transactional
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
    public List<Participant> getParticipants(League league) {
        return participantRepository.findAllByLeague(league);
    }
    public void deleteParticipant(Participant participant) {
        participantRepository.delete(participant);
    }
}
