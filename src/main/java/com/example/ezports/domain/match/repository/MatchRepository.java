package com.example.ezports.domain.match.repository;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByLeague(League league);
}
