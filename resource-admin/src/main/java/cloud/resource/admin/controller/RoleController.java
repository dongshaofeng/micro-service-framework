package cloud.resource.admin.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.resource.admin.feign.AuthApi;
import cloud.resource.admin.persistence.entity.RoleEntity;
import cloud.resource.admin.persistence.entity.UserAccountEntity;
import cloud.resource.admin.persistence.repository.RoleRepository;
import cloud.resource.admin.persistence.repository.UserAccountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "角色接口", tags = {"角色接口"})
@RestController
@RequestMapping(path="/admin/role") 
public class RoleController {
    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");
    @Autowired
    AuthApi authApi;
    
    @Autowired
    RoleRepository roleRepository;

    @ApiOperation(value = "用户列表")
    @GetMapping("/listAll")
    public List<RoleEntity> userlist() {
      	List<RoleEntity> result = roleRepository.findAll();
        return result;
    }
}
     
