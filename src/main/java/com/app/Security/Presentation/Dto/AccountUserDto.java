package com.app.Security.Presentation.Dto;

import java.util.Set;

import com.app.Security.persistence.entity.RoleEntity;
import com.app.utilities.Enum.QuestionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserDto {
    private String username;
    private String apodo;
    private QuestionEnum pregunta;
    private String respuesta;
    private Set<RoleEntity> roles;
    private String password;

}
