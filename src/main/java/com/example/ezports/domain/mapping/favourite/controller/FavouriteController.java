package com.example.ezports.domain.mapping.favourite.controller;

import com.example.ezports.domain.mapping.favourite.dto.FavouriteResponseDTO;
import com.example.ezports.domain.mapping.favourite.service.FavouriteService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
@RequiredArgsConstructor
public class FavouriteController {
    private final FavouriteService favouriteService;

    @PostMapping("/league/{leagueId}")
    public ApiResponse createFavouriteLeague(
            @PathVariable Long leagueId
    ) {
        favouriteService.addFavouriteLeague(leagueId);
        return ApiResponse.onSuccess("");
    }

    @PostMapping("/team/{teamId}")
    public ApiResponse addFavouriteTeam(
            @PathVariable Long teamId
    ) {
        favouriteService.addFavouriteTeam(teamId);
        return ApiResponse.onSuccess("");
    }

    @GetMapping("/league")
    public ApiResponse<List<FavouriteResponseDTO.favouriteLeague>> getFavouriteLeague(
    ) {
        return ApiResponse.onSuccess(favouriteService.getFavouriteLeagues());
    }

    @GetMapping("/team")
    public ApiResponse<List<FavouriteResponseDTO.favouriteTeam>> getFavouriteTeam(
    ) {
        return ApiResponse.onSuccess(favouriteService.getFavouriteTeams());
    }


}
