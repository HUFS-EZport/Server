package com.example.ezports.domain.member.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailCodeRepository extends JpaRepository<EmailCode, Long>{
}
