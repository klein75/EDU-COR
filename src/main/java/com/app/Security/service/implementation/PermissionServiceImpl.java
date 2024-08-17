package com.app.Security.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Security.persistence.entity.PermissionEntity;
import com.app.Security.persistence.repository.PermissionRepository;
import com.app.Security.service.interfaces.IPermissionService;
import com.app.utilities.Enum.StateEnum;

@Service
public class PermissionServiceImpl implements IPermissionService {
    
    @Autowired
    private PermissionRepository pRepository;

    

    @Override
    public List<PermissionEntity> getAllPermission() {
        return pRepository.findAll();
    }

    @Override
    public Optional<PermissionEntity> getAllPermissionById(long id) {
        return pRepository.findById(id);
    }

    @Override
    public Optional<PermissionEntity> getAllPermissionByName(String name) {
       return pRepository.findByName(name);
    }

    @Override
    public Optional<PermissionEntity> getAllPermissionByState(StateEnum state) {
        return pRepository.findByEstado(state);
    }

    @Override
    public PermissionEntity createPermission(PermissionEntity permission) {
        return pRepository.save(permission);
    
    }

    @Override
    public PermissionEntity updatePermission(Long id, PermissionEntity permissions) {
       PermissionEntity permission = pRepository.getReferenceById(id);
       permission.setName(permission.getName());
       permission.setEstado(permission.getEstado());
       return pRepository.save(permission);
    }

    @Override
    public void deletePermission(long id) {
        
        pRepository.deleteById(id);
    }


}
