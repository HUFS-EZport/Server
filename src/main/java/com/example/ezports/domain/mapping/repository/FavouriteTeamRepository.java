package com.example.ezports.domain.mapping.repository;

import com.example.ezports.domain.mapping.entity.FavouriteTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteTeamRepository extends JpaRepository<FavouriteTeam, Long> {
}
