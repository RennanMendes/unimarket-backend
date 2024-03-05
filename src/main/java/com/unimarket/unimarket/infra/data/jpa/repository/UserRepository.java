package com.unimarket.unimarket.infra.data.jpa.repository;

import com.unimarket.unimarket.infra.data.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.id = ?1 AND u.isActive = true")
    boolean existsByIdAndIsActiveTrue(Long id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.email = ?1 AND u.isActive = true")
    boolean existsByEmailAndIsActiveTrue(String email);


    UserEntity findByIdAndIsActiveTrue(Long id);
}
