package com.nhom1.java6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false, length = 10)
    private String id;

    @Column(name = "Name", nullable = true, length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<AuthoritiesEntity> authoritiesEntities;
}
