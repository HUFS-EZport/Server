package com.example.ezports.domain.mapping.participant.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.mapping.participant.repository.ParticipantRepository;
import com.example.ezports.domain.team.entity.Team;
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
    @Transactional
    public List<Participant> getParticipants(League league) {
        return participantRepository.findAllByLeague(league);
    }

    @Transactional
    public List<Participant> getLeaguesByTeam(Team team) {
        return participantRepository.findAllByTeam(team);
    }
    public void deleteParticipant(Participant participant) {
        participantRepository.delete(participant);
    }
}
