package com.nhom1.java6.Service;

import com.nhom1.java6.Repository.AccountRepo;
import com.nhom1.java6.model.AccountsEntity;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
//    @Autowired
//    private AccountRepo accountRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try{
//            AccountsEntity account = accountRepo.findById(username).get();
//
//            String password = account.getPassword();
//            String [] roles = account.getAuthoritiesEntities().stream()
//                    .map(au -> au.getRole().getId()).toArray(String[]::new);
//            return User.withUsername(username)
//                    .password(password)
//                    .roles(roles).build();
//        }catch (Exception e){
//            throw new UsernameNotFoundException(username + "not found");
//        }
//    }

    public void loginFromOAuth2(OAuth2AuthenticationToken oauth2){
        String email = oauth2.getPrincipal().getAttribute("email");
//        String password = Long.toHexString(System.currentTimeMillis());
//
//        UserDetails user = User.withUsername(email)
//                .password(password).roles("GUEST").build();
        Authentication auth = new UsernamePasswordAuthenticationToken(email,null, List.of(new SimpleGrantedAuthority("GUEST")));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

}
