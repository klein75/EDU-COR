package com.app.Security.Presentation.Dto;

import java.sql.Date;

import com.app.utilities.Enum.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoUserDto {
    private Long id;
    private String nombreUno;
    private String nombreDos;
    private String apellidoUno;
    private String apellidoDos;
    private Date fechaNaci;
    private String edad;
    private GenderEnum sexo;
    private String correo;
    private String telefono;

}
