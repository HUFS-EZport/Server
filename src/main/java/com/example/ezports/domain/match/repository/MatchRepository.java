package com.example.ezports.domain.match.repository;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByLeague(League league);

    @Query("SELECT m FROM Match m WHERE m.homeTeam = :team OR m.awayTeam = :team")
    List<Match> findAllByTeam(@Param("team") Team team);
}
