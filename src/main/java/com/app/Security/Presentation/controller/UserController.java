package com.app.Security.Presentation.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Security.Presentation.Dto.GeneralUserDto;
import com.app.Security.Presentation.Dto.InfoUserDto;
import com.app.Security.persistence.entity.UserEntity;
import com.app.Security.service.interfaces.IUserServices;
import com.app.utilities.Enum.GenderEnum;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserServices userService;

    @PostMapping
    public ResponseEntity<GeneralUserDto> createUser(@RequestBody GeneralUserDto userDto) {
        GeneralUserDto createdUser = userService.saveUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralUserDto> updateUser(@PathVariable Long id, @RequestBody GeneralUserDto userDto) {
        UserEntity updatedUser = userService.updateUser(id, userDto);
        GeneralUserDto updatedUserDto = userService.convertToDto(updatedUser);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<InfoUserDto>> getAllUsers() {
        List<InfoUserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoUserDto> getUserById(@PathVariable Long id) {
        InfoUserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/nombreUno/{nombreUno}")
    public ResponseEntity<List<InfoUserDto>> getUserByNombreUno(@PathVariable String nombreUno) {
        List<InfoUserDto> users = userService.getUserByNombreUno(nombreUno);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/apellidoUno/{apellidoUno}")
    public ResponseEntity<List<InfoUserDto>> getUserByApellidoUno(@PathVariable String apellidoUno) {
        List<InfoUserDto> users = userService.getUserByApellidoUno(apellidoUno);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<InfoUserDto> getUserByDocumento(@PathVariable String documento) {
        InfoUserDto user = userService.getUserByDocumento(documento);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/fechaNaci")
    public ResponseEntity<List<InfoUserDto>> getUserByFechaNaci(@RequestParam Date fechaNaci) {
        List<InfoUserDto> users = userService.getUserByFechaNaci(fechaNaci);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/tipoSangre/{tipoSangre}")
    public ResponseEntity<List<InfoUserDto>> getUserByTipoSangre(@PathVariable String tipoSangre) {
        List<InfoUserDto> users = userService.getUserByTipoSangre(tipoSangre);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<List<InfoUserDto>> getUserBySexo(@PathVariable GenderEnum sexo) {
        List<InfoUserDto> users = userService.getUserBySexo(sexo);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<InfoUserDto> getUserByCorreo(@PathVariable String correo) {
        InfoUserDto user = userService.getUserByCorreo(correo);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<InfoUserDto> getUserByTelefono(@PathVariable String telefono) {
        InfoUserDto user = userService.getUserByTelefono(telefono);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/apodo/{apodo}")
    public ResponseEntity<InfoUserDto> getUserByApodo(@PathVariable String apodo) {
        InfoUserDto user = userService.getUserByApodo(apodo);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/acudiente")
    public ResponseEntity<List<InfoUserDto>> getUserByAcudiente(@RequestParam boolean acudiente) {
        List<InfoUserDto> users = userService.getUserByAcudiente(acudiente);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/calculateAge")
    public ResponseEntity<Integer> calculateAge(@RequestParam Date birthDate) {
        int age = userService.calculateAge(birthDate);
        return new ResponseEntity<>(age, HttpStatus.OK);
    }
}
