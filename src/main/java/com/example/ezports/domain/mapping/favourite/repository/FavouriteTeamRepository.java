package com.example.ezports.domain.mapping.favourite.repository;

import com.example.ezports.domain.mapping.favourite.entity.FavouriteTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteTeamRepository extends JpaRepository<FavouriteTeam, Long> {
    boolean existsByMember_IdAndTeam_Id(Long memberId, Long teamId);

    Optional<FavouriteTeam> findByMember_IdAndTeam_Id(Long memberId, Long teamId);

    List<FavouriteTeam> findAllByMember_Id(Long memberId);
}
