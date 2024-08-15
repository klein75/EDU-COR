package com.app.Security.Presentation.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Security.persistence.entity.PermissionEntity;
import com.app.Security.service.interfaces.IPermissionService;
import com.app.utilities.Enum.StateEnum;

@RestController
@RequestMapping("/api/permisos")
public class PermissionController {


         @Autowired
    private IPermissionService permissionService;

    // Obtener todos los permisos
    @GetMapping("/ver")
    public List<PermissionEntity> getAllPermissions() {
        return permissionService.getAllPermission();
    }

    // Obtener un permiso por ID
    @GetMapping("/por/{id}")
    public ResponseEntity<PermissionEntity> getPermissionById(@PathVariable(value = "id") Long id) {
        Optional<PermissionEntity> permission = permissionService.getAllPermissionById(id);
        return permission.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener un permiso por nombre
    @GetMapping("/name/{name}")
    public ResponseEntity<PermissionEntity> getPermissionByName(@PathVariable(value = "name") String name) {
        Optional<PermissionEntity> permission = permissionService.getAllPermissionByName(name);
        return permission.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener permisos por estado
    @GetMapping("/state/{state}")
    public Optional<PermissionEntity> getPermissionsByState(@PathVariable(value = "state") StateEnum state) {
        return permissionService.getAllPermissionByState(state);
    }

    // Crear un nuevo permiso
    @PostMapping("/crear")
    public ResponseEntity<PermissionEntity> createPermission(@RequestBody PermissionEntity permission) {
        PermissionEntity createdPermission = permissionService.createPermission(permission);
        return ResponseEntity.ok(createdPermission);
    }

    // Actualizar un permiso existente
    @PutMapping("/Modificar/{id}")
    public ResponseEntity<PermissionEntity> updatePermission(@PathVariable(value = "id") Long id,
                                                             @RequestBody PermissionEntity permissionDetails) {
        PermissionEntity updatedPermission = permissionService.updatePermission(id, permissionDetails);
        return ResponseEntity.ok(updatedPermission);
    }

    // Eliminar un permiso
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable(value = "id") Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
    


