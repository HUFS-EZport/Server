package com.example.ezports.domain.mapping.service;

import com.example.ezports.domain.mapping.repository.FavouriteLeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavouriteLeagueService {
    private final FavouriteLeagueRepository favouriteLeagueRepository;
}
