package com.example.ezports.domain.sport.repository;

import com.example.ezports.domain.sport.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
