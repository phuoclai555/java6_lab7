package com.nhom1.java6.RestController;

import com.nhom1.java6.Repository.AccountRepo;
import com.nhom1.java6.Repository.AuthorityRepo;
import com.nhom1.java6.Repository.RoleRepo;
import com.nhom1.java6.model.AuthoritiesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class authrityRestController {
    @Autowired
    AuthorityRepo authorityRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/rest/authorities")
    public Map<String,Object> getAuthorities(){
        Map<String,Object> data = new HashMap<>();
        data.put("authorities",authorityRepo.findAll());
        data.put("roles",roleRepo.findAll());
        data.put("accounts",accountRepo.findAll());
        return data;
    }

    @PostMapping("/rest/authorities")
    public AuthoritiesEntity create(@RequestBody AuthoritiesEntity authoritiesEntity){
        return authorityRepo.save(authoritiesEntity);
    }

    @DeleteMapping("/rest/authorities/{id}")
    public void delete(@PathVariable("id") Integer id){
        authorityRepo.deleteById(id);
    }
}
