package cloud.oauth2.server.service.impl;

import cloud.oauth2.server.domain.NotImplementException;
import cloud.oauth2.server.domain.Role;
import cloud.oauth2.server.persistence.entity.RoleEntity;
import cloud.oauth2.server.persistence.entity.UserAccountEntity;
import cloud.oauth2.server.persistence.repository.RoleRepository;
import cloud.oauth2.server.service.RoleService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
 
    @Override
    public Role findByRoleName(String roleName) throws NotImplementException {
        RoleEntity roleEntity = roleRepository.findByRoleName(roleName); 
        Role role =  new Role(); 
        if (roleEntity != null) {
        	    BeanUtils.copyProperties(roleEntity,role); 
            return role;
        } else {
            return null;
        }
    }

}
