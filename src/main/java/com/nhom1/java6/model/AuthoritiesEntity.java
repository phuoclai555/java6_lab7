package com.nhom1.java6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Authorities")
public class AuthoritiesEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer  id;

    @ManyToOne
    @JoinColumn(name = "Username")
    private AccountsEntity account;

    @ManyToOne
    @JoinColumn(name = "Roleid")
    private RolesEntity role;
}
