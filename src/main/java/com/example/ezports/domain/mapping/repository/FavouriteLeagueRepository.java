package com.example.ezports.domain.mapping.repository;

import com.example.ezports.domain.mapping.entity.FavouriteLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteLeagueRepository extends JpaRepository<FavouriteLeague, Long> {
}
