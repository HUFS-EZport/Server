package com.example.ezports.domain.sport.controller;

import com.example.ezports.domain.sport.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {
    private final SportService sportService;

    @PostMapping
    public void createSport() {
    }

    @GetMapping
    public void getSports() {
    }

    @GetMapping("/{sportId}/leagues")
    public void getLeagues() {
    }

    @PutMapping("/{sportId}")
    public void updateSport() {
    }

    @DeleteMapping("/{sportId}")
    public void deleteSport() {
    }

}
