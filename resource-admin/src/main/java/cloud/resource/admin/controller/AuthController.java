package cloud.resource.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value = "sso client 接口", tags = {"sso client 接口"})
@RestController
@RequestMapping(path="/auth") 
public class AuthController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");
    @Autowired
    AuthApi authApi;
  
    
    @ResponseBody
    @RequestMapping(value = "/oauth/getToken", method = RequestMethod.POST)
    @ApiOperation(value = "/oauth/getToken", notes = "用户获取token，登录", httpMethod = "POST")
    public String getToken(@RequestParam(value = "username", required = true) String username,
    		@RequestParam(value = "password", required = true) String password)  {
        String url = "http://127.0.0.1:30203/oauth/token";
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//  也支持中文
        params.add("grant_type", "password");
        params.add("scope", "user_info");
        params.add("client_id", "SampleClientId");
        params.add("client_secret", "tgb.258");
        params.add("username", username);
        params.add("password", password);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);

        String jsonString = response.getBody();
 
        log.debug(jsonString); 

//       String s =  authApi.getToken(username , password,"password","user_info","SampleClientId","tgb.258");
//      
//       return s;
        return jsonString;
    }
    
    @ResponseBody
    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
//    @ApiOperation(value = "/user/me", notes = "获取用户信息", httpMethod = "GET")
    public String getUserinfo(@RequestParam(value = "access_token", required = false) String paramToken,
            @RequestHeader(value = "Authorization", required = false) String headerToken,
            @CookieValue(value = "access_token", required = false) String cookieToken) {
    	
        String url = "http://127.0.0.1:30203/user/me"; 
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//  也支持中文
        String jsonString ="";
        try {
            String token = null;
            if (StringUtils.isNoneBlank(headerToken)) {
                Matcher matcher = AUTHORIZATION_PATTERN.matcher(headerToken);
                if (matcher.matches()) {
                    token = matcher.group("token");
                }
            }

            if (token == null && StringUtils.isNoneBlank(paramToken)) {
                token = paramToken;
            }

            if (token == null && StringUtils.isNoneBlank(cookieToken)) {
                token = cookieToken;
            }

            if (token != null) {
			        params.add("access_token", token); 
			        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
			//  执行HTTP请求
			        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
			
			         jsonString = response.getBody(); 
			//  输出结果
//			        System.out.println(jsonString);
            }
        }catch (Exception e) {
//                if (log.isInfoEnabled()) {
//                    log.info("/user/me exception", e);
//                } 
//               	responseItem.setCode("0");
//              	responseItem.setMessage("access_token无效");
            } 
        log.debug("me---"+jsonString); 
        return jsonString;
    }
 
}
