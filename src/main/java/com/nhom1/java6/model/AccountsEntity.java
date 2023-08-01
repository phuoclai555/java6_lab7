package com.nhom1.java6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class AccountsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Username", nullable = false, length = 20)
    private String username;

    @Column(name = "Password", nullable = true, length = 10)
    private String password;

    @Column(name = "Fullname", nullable = true, length = 50)
    private String fullname;

    @Column(name = "Email", nullable = true, length = 50)
    private String email;

    @Column(name = "Photo", nullable = true, length = 50)
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<AuthoritiesEntity> authoritiesEntities;
}
