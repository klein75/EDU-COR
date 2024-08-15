package com.app.Security.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Security.persistence.entity.RoleEntity;
import com.app.utilities.Enum.RoleEnum;


public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);

}
