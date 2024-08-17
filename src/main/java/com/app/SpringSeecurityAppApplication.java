package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.Security.persistence.entity.PermissionEntity;
import com.app.Security.persistence.entity.RoleEntity;
import com.app.Security.persistence.entity.UserEntity;
import com.app.Security.persistence.repository.UserRepository;
import com.app.utilities.Enum.RoleEnum;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSeecurityAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSeecurityAppApplication.class, args);
    }

//     @Bean
//     CommandLineRunner init(UserRepository userRepository) {
//         return args -> {
//             /* Create PERMISSIONS */
//             PermissionEntity createPermission = PermissionEntity.builder()
//                     .name("CREATE")
//                     .build();

//             PermissionEntity readPermission = PermissionEntity.builder()
//                     .name("READ")
//                     .build();

//             PermissionEntity updatePermission = PermissionEntity.builder()
//                     .name("UPDATE")
//                     .build();

//             PermissionEntity deletePermission = PermissionEntity.builder()
//                     .name("DELETE")
//                     .build();

//             PermissionEntity refactorPermission = PermissionEntity.builder()
//                     .name("REFACTOR")
//                     .build();

//             PermissionEntity evaluarPermission = PermissionEntity.builder()
//                     .name("EVALUAR")
//                     .build();
//             PermissionEntity administrarPermission = PermissionEntity.builder()
//                  	 .name("ADMINISTAR")
//                          .build();

//             /* Create ROLES */
//             RoleEntity roleAdmin = RoleEntity.builder()
//                     .roleEnum(RoleEnum.ADMIN)
//                     .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, administrarPermission))
//                     .build();

//             RoleEntity roleDocente = RoleEntity.builder()
//                     .roleEnum(RoleEnum.DOCENTE)
//                     .permissionList(Set.of(createPermission, readPermission, updatePermission,evaluarPermission))
//                     .build();

//             RoleEntity roleInvited = RoleEntity.builder()
//                     .roleEnum(RoleEnum.ALUMNO)
//                     .permissionList(Set.of(readPermission))
//                     .build();

//             RoleEntity roleDeveloper = RoleEntity.builder()
//                     .roleEnum(RoleEnum.DEVELOPER)
//                     .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
//                     .build();

//             /* CREATE USERS */
//         //     UserEntity userSantiago = UserEntity.builder()
//         //             .username("santiago")
//         //             .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//         //             .isEnabled(true)
//         //             .accountNoExpired(true)
//         //             .accountNoLocked(true)
//         //             .credentialNoExpired(true)
//         //             .roles(Set.of(roleAdmin))
//         //             .build();

//         //     UserEntity userDaniel = UserEntity.builder()
//         //             .username("daniel")
//         //             .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//         //             .isEnabled(true)
//         //             .accountNoExpired(true)
//         //             .accountNoLocked(true)
//         //             .credentialNoExpired(true)
//         //             .roles(Set.of(roleUser))
//         //             .build();

//         //     UserEntity userAndrea = UserEntity.builder()
//         //             .username("andrea")
//         //             .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//         //             .isEnabled(true)
//         //             .accountNoExpired(true)
//         //             .accountNoLocked(true)
//         //             .credentialNoExpired(true)
//         //             .roles(Set.of(roleInvited))
//         //             .build();

//             UserEntity userklein = UserEntity.builder()
//                     .username("klein")
//                     .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//                     .isEnabled(true)
//                     .accountNoExpired(true)
//                     .accountNoLocked(true)
//                     .credentialNoExpired(true)
//                     .roles(Set.of(roleDeveloper))
//                           .build();

//            userRepository.saveAll(List.of( userklein));
//         };
    }

