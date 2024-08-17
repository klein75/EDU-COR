package com.app.Security.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Security.persistence.entity.PermissionEntity;
import com.app.utilities.Enum.StateEnum;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findByName(String name);

    Optional<PermissionEntity> findByEstado(StateEnum state);

}
