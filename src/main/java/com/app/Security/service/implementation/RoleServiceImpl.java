package com.app.Security.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Security.persistence.entity.RoleEntity;
import com.app.Security.persistence.repository.RoleRepository;
import com.app.Security.service.interfaces.IRoleService;
import com.app.utilities.Enum.RoleEnum;
import com.app.utilities.Exepcion.ResourceNotFoundException;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<RoleEntity> getRoleByRoleEnum(RoleEnum roleEnum) {
        return roleRepository.findByRoleEnum(roleEnum);
    }

    @Override
    public RoleEntity createRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity updateRole(Long id, RoleEntity roleDetails) {
        RoleEntity role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));

        role.setRoleEnum(roleDetails.getRoleEnum());
        role.setPermissionList(roleDetails.getPermissionList());
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        RoleEntity role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));

        roleRepository.delete(role);
    }
}
