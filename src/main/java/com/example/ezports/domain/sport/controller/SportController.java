package com.example.ezports.domain.sport.controller;

import com.example.ezports.domain.sport.dto.SportRequestDTO;
import com.example.ezports.domain.sport.dto.SportResponseDTO;
import com.example.ezports.domain.sport.service.SportService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {
    private final SportService sportService;

    @PostMapping
    public ApiResponse<SportResponseDTO.createSport> createSport(
            @RequestBody SportRequestDTO.createSport request
    ) {
        return ApiResponse.onSuccess(sportService.createSport(request));
    }

    @GetMapping
    public ApiResponse<List<SportResponseDTO.getSport>> getSports() {
        return ApiResponse.onSuccess(sportService.getSports());
    }

    @GetMapping("/{sportId}")
    public ApiResponse<SportResponseDTO.getSportInfo> getLeagues(
            @PathVariable Long sportId
    ) {
        return ApiResponse.onSuccess(sportService.getSportInfo(sportId));
    }

    @PutMapping("/{sportId}")
    public ApiResponse updateSport(
            @PathVariable Long sportId,
            @RequestBody SportRequestDTO.updateSport request
    ) {
        sportService.updateSport(sportId, request);
        return ApiResponse.onSuccess("");
    }

    @DeleteMapping("/{sportId}")
    public ApiResponse deleteSport(
            @PathVariable Long sportId
    ) {
        sportService.deleteSport(sportId);
        return ApiResponse.onSuccess("");
    }

}
