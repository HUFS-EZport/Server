package com.example.ezports.domain.mapping.controller;

import com.example.ezports.domain.mapping.service.FavouriteLeagueService;
import com.example.ezports.domain.mapping.service.FavouriteTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favourite")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteTeamService favouriteTeamService;
    private final FavouriteLeagueService favouriteLeagueService;

    @PostMapping("/league/{leagueId}")
    public void createFavouriteLeague(
            @PathVariable Long leagueId
    ) {
    }

    @PostMapping("/team/{teamId}")
    public void createFavouriteTeam(
            @PathVariable Long teamId
    ) {
    }

    @GetMapping("/league/{leagueId}")
    public void getFavouriteLeague(
            @PathVariable Long leagueId
    ) {
    }

    @GetMapping("/team/{teamId}")
    public void getFavouriteTeam(
            @PathVariable Long teamId
    ) {
    }

    @DeleteMapping("/league/{leagueId}")
    public void deleteFavouriteLeague(
            @PathVariable Long leagueId
    ) {
    }

    @DeleteMapping("/team/{teamId}")
    public void deleteFavouriteTeam(
            @PathVariable Long teamId
    ) {
    }

}
