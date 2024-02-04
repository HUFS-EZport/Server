package com.example.ezports.domain.mapping.service;

import com.example.ezports.domain.mapping.repository.FavouriteTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavouriteTeamService {
    private final FavouriteTeamRepository favouriteTeamRepository;
}
