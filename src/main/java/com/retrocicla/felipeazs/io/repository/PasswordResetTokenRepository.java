package com.retrocicla.felipeazs.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.PasswordResetTokenEntity;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetTokenEntity, Long>{

	PasswordResetTokenEntity findByToken(String token);

}
