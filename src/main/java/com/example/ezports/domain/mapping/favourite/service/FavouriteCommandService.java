package com.example.ezports.domain.mapping.favourite.service;

import com.example.ezports.domain.mapping.favourite.entity.FavouriteLeague;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteTeam;
import com.example.ezports.domain.mapping.favourite.repository.FavouriteLeagueRepository;
import com.example.ezports.domain.mapping.favourite.repository.FavouriteTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavouriteCommandService {
    private final FavouriteTeamRepository favouriteTeamRepository;
    private final FavouriteLeagueRepository favouriteLeagueRepository;
    public void createFavouriteTeam(FavouriteTeam favouriteTeam) {
        favouriteTeamRepository.save(favouriteTeam);
    }

    public void deleteFavouriteTeam(FavouriteTeam favouriteTeam) {
        favouriteTeamRepository.delete(favouriteTeam);
    }

    public void createFavouriteLeague(FavouriteLeague favouriteLeague) {
        favouriteLeagueRepository.save(favouriteLeague);
    }

    public void deleteFavouriteLeague(FavouriteLeague favouriteLeague) {
        favouriteLeagueRepository.delete(favouriteLeague);
    }
}
