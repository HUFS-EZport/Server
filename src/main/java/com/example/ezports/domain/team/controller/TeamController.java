package com.example.ezports.domain.team.controller;

import com.example.ezports.domain.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public void createTeam() {
    }

    @GetMapping("/{teamId}")
    public void getTeam() {
    }

    @PutMapping("/{teamId}")
    public void updateTeam() {
    }

    @DeleteMapping("/{teamId}")
    public void deleteTeam() {
    }


}
