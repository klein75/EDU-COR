package com.app.Security.service.interfaces;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.Security.persistence.entity.PermissionEntity;
import com.app.utilities.Enum.StateEnum;

@Service
public interface IPermissionService {
    List<PermissionEntity> getAllPermission();

    Optional<PermissionEntity> getAllPermissionById(long id);

    Optional<PermissionEntity> getAllPermissionByName(String name);

    Optional<PermissionEntity> getAllPermissionByState(StateEnum state);

    PermissionEntity createPermission(PermissionEntity permission);

    PermissionEntity updatePermission(Long id, PermissionEntity permissions);

    void deletePermission(long id);

}
