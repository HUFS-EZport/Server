package com.example.ezports.domain.league.repository;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.sport.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    List<League> findAllBySport(Sport sport);
}
