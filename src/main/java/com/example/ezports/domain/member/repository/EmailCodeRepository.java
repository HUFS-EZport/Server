package com.example.ezports.domain.member.repository;

import com.example.ezports.domain.member.entity.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCodeRepository extends JpaRepository<EmailCode, Long> {
}
