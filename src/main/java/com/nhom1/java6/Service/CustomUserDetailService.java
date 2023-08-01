package com.nhom1.java6.Service;

import com.nhom1.java6.Repository.AccountRepo;
import com.nhom1.java6.model.AccountsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    AccountRepo accountRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountsEntity> result = accountRepo.findById(username);
        AccountsEntity account = result.orElse(null);
        if(account == null){
            throw new BadCredentialsException("Account khong ton tai");
        }
        List<GrantedAuthority> roleName = account.getAuthoritiesEntities().stream()
                                    .map(authority -> new SimpleGrantedAuthority(authority.getRole().getId()))
                                    .collect(Collectors.toList());
//        UserDetails user =
//        UsernamePasswordAuthenticationToken
        return User.builder()
                .username(username)
                .password(account.getPassword())
                .authorities(roleName)
                .build();
    }
}
