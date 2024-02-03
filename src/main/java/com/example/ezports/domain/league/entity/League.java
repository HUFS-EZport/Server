package com.example.ezports.domain.league.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import com.example.ezports.domain.mapping.entity.Participant;
import com.example.ezports.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class League extends BaseDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String information;

    private String logoUrl;

    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    private Set<Participant> participants = new HashSet<>();

    public void updateLeague(String name, String information) {
        this.name = name;
        this.information = information;
    }
}
