package com.nhom1.java6.Repository;

import com.nhom1.java6.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RolesEntity,String> {
}
