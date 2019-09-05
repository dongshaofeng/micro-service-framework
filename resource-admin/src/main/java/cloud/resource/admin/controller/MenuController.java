package cloud.resource.admin.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.resource.admin.feign.AuthApi;
import cloud.resource.admin.persistence.entity.ResourceEntity;
import cloud.resource.admin.persistence.entity.RoleEntity;
import cloud.resource.admin.persistence.repository.ResourceRepository;
import cloud.resource.admin.persistence.repository.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 

@Api(value = "菜单接口", tags = {"菜单接口"})
@RestController
@RequestMapping(path="/admin/menu") 
public class MenuController {
    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");
    @Autowired
    AuthApi authApi;
    
    @Autowired
    ResourceRepository resourceRepository;

    @ApiOperation(value = "菜单列表")
    @GetMapping("/listAll")
    public List<ResourceEntity> menu() {
      	List<ResourceEntity> result = resourceRepository.listall();
        return result;
    }
}
     
