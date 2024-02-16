package com.example.ezports.domain.mapping.favourite.repository;

import com.example.ezports.domain.mapping.favourite.entity.FavouriteLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteLeagueRepository extends JpaRepository<FavouriteLeague, Long> {
    Optional<FavouriteLeague> findByMember_IdAndLeague_Id(Long memberId, Long leagueId);

    boolean existsByMember_IdAndLeague_Id(Long memberId, Long leagueId);

    List<FavouriteLeague> findAllByMember_Id(Long memberId);
}
