package com.app.Security.service.interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.app.Security.Presentation.Dto.GeneralUserDto;
import com.app.Security.Presentation.Dto.InfoUserDto;
import com.app.Security.persistence.entity.UserEntity;
import com.app.utilities.Enum.GenderEnum;

public interface IUserServices {

    GeneralUserDto saveUser(GeneralUserDto generalUserDto);
    UserEntity updateUser(Long id, GeneralUserDto generalUserDto);
    void deleteUser(Long id);
    List<InfoUserDto> getAllUsers();
    InfoUserDto getUserById(Long id);
    
    
    List<InfoUserDto> getUserByNombreUno(String nombreUno);
    List<InfoUserDto> getUserByApellidoUno(String apellidoUno);
    InfoUserDto getUserByDocumento(String documento);
    List<InfoUserDto> getUserByFechaNaci(Date fechaNaci);
    List<InfoUserDto> getUserByTipoSangre(String tipoSangre);
    List<InfoUserDto> getUserBySexo(GenderEnum sexo);
    InfoUserDto getUserByCorreo(String correo);
    InfoUserDto getUserByTelefono(String telefono);
    InfoUserDto getUserByApodo(String apodo);
    List<InfoUserDto> getUserByAcudiente(boolean acudiente);
    
    int calculateAge(Date birthDate);
    GeneralUserDto convertToDto(UserEntity entity);

}
