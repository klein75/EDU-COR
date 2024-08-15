package com.app.Security.Presentation.Dto;

import java.sql.Date;

import com.app.utilities.Enum.DoctypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUserDto {

    private DoctypeEnum docType;
    private String documento;
    private String fechaExp;
    private String lugarExp;
    private Date fechaNaci;
    private String lugarNaci;
    private String tipoSangre;
}
