package cloud.resource.admin.controller;

 
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cloud.resource.admin.feign.AuthApi;
import cloud.resource.admin.persistence.entity.UserAccountEntity;
import cloud.resource.admin.persistence.repository.UserAccountRepository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value = "用户接口", tags = {"用户接口"})
@RestController
@RequestMapping(path="/admin/user") 
public class UserController {
    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");
    @Autowired
    AuthApi authApi;
    
    @Autowired
    UserAccountRepository userAccountRepository;

//    pageNo=0&pageNum=20&username=
    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public Page<UserAccountEntity> userlist(@RequestParam(value = "pageNo", required = true) int pageNo,
    		@RequestParam(value = "pageNum", required = true) int pageNum,
    		@RequestParam(value = "username", required = false) String username) {
    	  //判断排序类型及排序字段
//        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
        //获取pageable
    	    if (pageNo==0)
    	      	pageNo=1;
        Pageable pageable = new QPageRequest(pageNo-1,pageNum);
        
      	
        Page<UserAccountEntity> result = userAccountRepository.findAll(pageable);
        return result;
    }
    
     
 
}
