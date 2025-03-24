package com.coelpe.coelpe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
//in h2 console cannot use 'user' for table name, because it's a reserved name ( so before switching to postgree we need to use 'users' )
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotBlank
    @Column(name = "username", unique = true)
    private String username;

    @NonNull
    @NotBlank
    @Column(name = "password")
    private String password;
}