package com.nhom1.java6.Repository;

import com.nhom1.java6.model.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountsEntity, String> {
    @Query(value = "select acc from AccountsEntity acc join fetch acc.authoritiesEntities auth " +
            "join fetch auth.role role WHERE acc.username = ?1")
    @Override
    Optional<AccountsEntity> findById(String username);
}
