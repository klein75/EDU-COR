package com.app.Security.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.Security.persistence.entity.UserEntity;
import com.app.utilities.Enum.GenderEnum;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);
    List<UserEntity> findByNombreUno(String nombreUno);
    List<UserEntity> findByApellidoUno(String apellidoUno);
    Optional<UserEntity> findByDocumento(String documento);
    List<UserEntity> findByFechaNaci(Date fechaNaci);
    List<UserEntity> findByTipoSangre(String tipoSangre);
    List<UserEntity> findBySexo(GenderEnum sexo);
    Optional<UserEntity> findByCorreo(String correo);
    Optional<UserEntity> findByTelefono(String telefono);
    Optional<UserEntity> findByApodo(String apodo);
    List<UserEntity> findByAcudiente(boolean acudiente);
  
}



