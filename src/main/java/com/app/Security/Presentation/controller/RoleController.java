package com.app.Security.Presentation.controller;
import com.app.Security.persistence.entity.RoleEntity;
import com.app.Security.service.interfaces.IRoleService;
import com.app.utilities.Enum.RoleEnum;
import com.app.utilities.Exepcion.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    // Obtener todos los roles
    @GetMapping
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<RoleEntity> getRoleById(@PathVariable(value = "id") Long id) {
        RoleEntity role = roleService.getRoleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
        return ResponseEntity.ok().body(role);
    }

    // Obtener un rol por RoleEnum
    @GetMapping("/roleEnum/{roleEnum}")
    public ResponseEntity<RoleEntity> getRoleByRoleEnum(@PathVariable(value = "roleEnum") RoleEnum roleEnum) {
        RoleEntity role = roleService.getRoleByRoleEnum(roleEnum)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this roleEnum :: " + roleEnum));
        return ResponseEntity.ok().body(role);
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity role) {
        RoleEntity createdRole = roleService.createRole(role);
        return ResponseEntity.ok(createdRole);
    }

    // Actualizar un rol existente
  @PutMapping("/{id}")
public ResponseEntity<RoleEntity> updateRole(@PathVariable(value = "id") Long id, @RequestBody RoleEntity roleDetails) {
    try {
        RoleEntity updatedRole = roleService.updateRole(id, roleDetails);
        return ResponseEntity.ok(updatedRole);
    } catch (ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (RelationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // O cualquier otro código de estado adecuado
    }
}
    // Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable(value = "id") Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
