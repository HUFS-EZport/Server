package com.example.ezports.domain.league.entity;

import com.example.ezports.domain.common.BaseDateTimeEntity;
import com.example.ezports.domain.mapping.participant.entity.Participant;
import com.example.ezports.domain.sport.entity.Sport;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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

    @JoinColumn(name = "sportId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sport sport;

    public void updateLeague(String name, String information) {
        this.name = name;
        this.information = information;
    }
}
