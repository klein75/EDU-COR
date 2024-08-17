package com.app.Security.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.utilities.Enum.DoctypeEnum;
import com.app.utilities.Enum.GenderEnum;
import com.app.utilities.Enum.QuestionEnum;
import com.app.utilities.Enum.StateEnum;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_uno")
    private String nombreUno;

    @Column(name = "nombre_dos")
    private String nombreDos;

    @Column(name = "apellido_uno")
    private String apellidoUno;

    @Column(name = "apellido_dos")
    private String apellidoDos;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doc")
    private DoctypeEnum docType;

    @Column(name = "documento") 
    private String documento;

    @Column(name = "fecha_exp")
    private String fechaExp;

    @Column(name = "lugar_exp")
    private String lugarExp;

    @Column(name = "fecha_naci")
    private Date fechaNaci;

    @Column(name = "lugar_naci")
    private String lugarNaci;

    @Column(name = "edad")
    private String edad;


    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private GenderEnum sexo;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "imagen")
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "pregunta")  
    private QuestionEnum pregunta;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "acudiente")
    private boolean acudiente;

    @Column(unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private StateEnum estado;
    
}