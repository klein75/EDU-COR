package com.app.Security.service.interfaces;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import com.app.Security.persistence.entity.RoleEntity;
import com.app.utilities.Enum.RoleEnum;

public interface IRoleService {
     List<RoleEntity> getAllRoles();
    Optional<RoleEntity> getRoleById(Long id);
    Optional<RoleEntity> getRoleByRoleEnum(RoleEnum roleEnum);
    RoleEntity createRole(RoleEntity role);
    RoleEntity updateRole(Long id, RoleEntity roleDetails) throws RelationNotFoundException;
    void deleteRole(Long id);

}
