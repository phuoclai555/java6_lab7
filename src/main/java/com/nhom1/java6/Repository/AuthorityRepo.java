package com.nhom1.java6.Repository;

import com.nhom1.java6.model.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepo extends JpaRepository<AuthoritiesEntity,Integer> {
}
