package com.example.demoapp.business;


import com.example.demoapp.domain.Role;
import com.example.demoapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleManager {
    private final RoleRepository roleRepository;

    public List<Role> getRoles(List<String> roleName){
        return roleRepository.findAllByNameIn(roleName);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
