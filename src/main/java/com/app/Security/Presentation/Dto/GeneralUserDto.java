package com.app.Security.Presentation.Dto;

import com.app.utilities.Enum.StateEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUserDto {

    private GeneralUserDto generalUser;
    private AccountUserDto accountUser;
    private DocumentUserDto document;
    private boolean acudiente;
    private boolean isEnabled;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private StateEnum estado;
 
}
