package com.app.Security.service.implementation;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.Security.Presentation.Dto.GeneralUserDto;
import com.app.Security.Presentation.Dto.InfoUserDto;
import com.app.Security.persistence.entity.UserEntity;
import com.app.Security.persistence.repository.UserRepository;
import com.app.Security.service.interfaces.IUserServices;
import com.app.utilities.Enum.GenderEnum;


import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServicesImpl implements IUserServices {

    @Autowired
    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();


    public GeneralUserDto saveUser(GeneralUserDto generalUserDto) {
       
        UserEntity user = convertToEntity(generalUserDto);
        UserEntity savedUser = userRepository.save(user);
 
        GeneralUserDto savedUserDto = convertToDto(savedUser);
        
        return savedUserDto;
    }
    @Override
    public UserEntity updateUser(Long id, GeneralUserDto generalUserDto) {
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserEntity user = convertToEntity(generalUserDto);
            user.setId(id); 
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

   @Override
public List<InfoUserDto> getAllUsers() {
    List<UserEntity> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    
    return users.stream()
            .map(entity -> modelMapper.map(entity, InfoUserDto.class))
            .collect(Collectors.toList());
}

    @Override
    public InfoUserDto getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        return modelMapper.map(user, InfoUserDto.class);
    }

    @Override
    public List<InfoUserDto> getUserByNombreUno(String nombreUno) {
        List<UserEntity> users = userRepository.findByNombreUno(nombreUno);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfoUserDto> getUserByApellidoUno(String apellidoUno) {
        List<UserEntity> users = userRepository.findByApellidoUno(apellidoUno);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InfoUserDto getUserByDocumento(String documento) {
        UserEntity user = userRepository.findByDocumento(documento)
                .orElseThrow(() -> new EntityNotFoundException("User not found with documento: " + documento));
        return modelMapper.map(user, InfoUserDto.class);
    }

    @Override
    public List<InfoUserDto> getUserByFechaNaci(Date fechaNaci) {
        List<UserEntity> users = userRepository.findByFechaNaci(fechaNaci);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfoUserDto> getUserByTipoSangre(String tipoSangre) {
        List<UserEntity> users = userRepository.findByTipoSangre(tipoSangre);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfoUserDto> getUserBySexo(GenderEnum sexo) {
        List<UserEntity> users = userRepository.findBySexo(sexo);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InfoUserDto getUserByCorreo(String correo) {
        UserEntity user = userRepository.findByCorreo(correo)
                .orElseThrow(() -> new EntityNotFoundException("User not found with correo: " + correo));
        return modelMapper.map(user, InfoUserDto.class);
    }

    @Override
    public InfoUserDto getUserByTelefono(String telefono) {
        UserEntity user = userRepository.findByTelefono(telefono)
                .orElseThrow(() -> new EntityNotFoundException("User not found with telefono: " + telefono));
        return modelMapper.map(user, InfoUserDto.class);
    }

    @Override
    public InfoUserDto getUserByApodo(String apodo) {
        UserEntity user = userRepository.findByApodo(apodo)
                .orElseThrow(() -> new EntityNotFoundException("User not found with apodo: " + apodo));
        return modelMapper.map(user, InfoUserDto.class);
    }

    @Override
    public List<InfoUserDto> getUserByAcudiente(boolean acudiente) {
        List<UserEntity> users = userRepository.findByAcudiente(acudiente);
        return users.stream()
                .map(entity -> modelMapper.map(entity, InfoUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public int calculateAge(Date birthDate) {
        LocalDate birth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birth, LocalDate.now()).getYears();
    }

    
    private UserEntity convertToEntity(GeneralUserDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    public GeneralUserDto convertToDto(UserEntity entity) {
        return modelMapper.map(entity, GeneralUserDto.class);
    }
}
   


