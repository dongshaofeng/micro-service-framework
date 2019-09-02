package cloud.oauth2.server.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;

import arterycloud.common.bean.ResponseItem;
import cloud.oauth2.server.domain.EntityNotFoundException;
import cloud.oauth2.server.domain.UserAccount;
import cloud.oauth2.server.domain.UserMe;
import cloud.oauth2.server.service.UserAccountService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ProfileController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final Pattern AUTHORIZATION_PATTERN = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    TokenStore tokenStore;

    @ResponseBody
    @RequestMapping("/user/me")
    public ResponseItem<UserMe> info(@RequestParam(value = "access_token", required = false) String paramToken,
                                    @RequestHeader(value = "Authorization", required = false) String headerToken,
                                    @CookieValue(value = "access_token", required = false) String cookieToken) {
    	ResponseItem<UserMe> responseItem = new ResponseItem<UserMe>(); 
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
                OAuth2AccessToken auth2AccessToken = tokenStore.readAccessToken(token);
                if (auth2AccessToken.isExpired()) { 
                	responseItem.setCode("0");
                	responseItem.setMessage("access_token无效");
                    
                }

                String username = auth2AccessToken.getAdditionalInformation().get("sub").toString();
                UserAccount userAccount = userAccountService.findByUsername(username);
                
                UserMe userMe = new UserMe();
                BeanUtils.copyProperties(userAccount, userMe);
//                result.put("username", username);
//                if (StringUtils.isNotEmpty(userAccount.getGender())) {
//                    result.put("gender", userAccount.getGender());
//                }
//                if (StringUtils.isNotEmpty(userAccount.getNickName())) {
//                    result.put("nickName", userAccount.getNickName());
//                }
//                result.put("grantType", auth2AccessToken.getAdditionalInformation().get("grantType"));
//                result.put("accountOpenCode", "" + userAccount.getId());
//                result.put("authorities", auth2AccessToken.getAdditionalInformation().get("authorities"));
//                result.put("status", 1);
////                result.put("menu", "{\"nickName\":\"张三\",\"accountOpenCode\":\"1\",\"grantType\":\"password\",\"authorities\":[\"ROLE_SUPER\"],\"username\":\"zhangsan\",\"status\":1}");
//                result.put("datarights", "10010,20010");
//                
//                result.put("permissions",  auth2AccessToken.getAdditionalInformation().get("authorities"));
//                result.put("roles", auth2AccessToken.getAdditionalInformation().get("authorities"));
//                result.put("user", "{\"nickName\":\"张三\",\"accountOpenCode\":\"1\",\"grantType\":\"password\",\"authorities\":[\"ROLE_SUPER\"],\"username\":\"zhangsan\",\"status\":1}");
                userMe.setRoles(auth2AccessToken.getAdditionalInformation().get("authorities").toString());
                userMe.setPermissions(auth2AccessToken.getAdditionalInformation().get("authorities").toString());
                responseItem.setData(userMe);
            } else { 
              	responseItem.setCode("0");
              	responseItem.setMessage("未检测到access_token");
            } 
        } catch (Exception e) {
            if (log.isInfoEnabled()) {
                log.info("/user/me exception", e);
            } 
           	responseItem.setCode("0");
          	responseItem.setMessage("access_token无效");
        }
        log.debug("JSON.toJSONString(responseItem)");
        return responseItem;
    }


    @GetMapping(value = {"", "/", "/user/profile"})
    public String profile(Principal principal,
                          Model model) {
        try {
            UserAccount userAccount = userAccountService.findByUsername(principal.getName());
            model.addAttribute("userAccount", userAccount);
        } catch (EntityNotFoundException e) {
            if (log.isErrorEnabled()) {
                log.error("findByUsername exception", e);
            }
        }

        return "profile";
    }

    @PostMapping("/user/profile")
    public String handleProfile(Principal principal,
                                @RequestParam(value = "nickName", required = false) String nickName,
                                @RequestParam(value = "avatarUrl", required = false) String avatarUrl,
                                @RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "mobile", required = false) String mobile,
                                @RequestParam(value = "province", required = false) String province,
                                @RequestParam(value = "city", required = false) String city,
                                @RequestParam(value = "address", required = false) String address,
                                @JsonFormat(pattern = "MM-dd-yyyy") @DateTimeFormat(pattern = "MM-dd-yyyy")
                                @RequestParam(value = "birthday", required = false) Date birthday,
                                Model model) {

        try {
            UserAccount userAccount = userAccountService.findByUsername(principal.getName());
            userAccount.setNickName(StringEscapeUtils.escapeHtml4(nickName));
            userAccount.setAvatarUrl(StringEscapeUtils.escapeHtml4(avatarUrl));
            userAccount.setEmail(StringEscapeUtils.escapeHtml4(email));
            userAccount.setMobile(StringEscapeUtils.escapeHtml4(mobile));
            userAccount.setProvince(StringEscapeUtils.escapeHtml4(province));
            userAccount.setCity(StringEscapeUtils.escapeHtml4(city));
            userAccount.setAddress(StringEscapeUtils.escapeHtml4(address));
            userAccount.setBirthday(birthday);
            userAccount = userAccountService.updateById(userAccount);
            model.addAttribute("userAccount", userAccount);
            model.addAttribute("updated", true);
        } catch (EntityNotFoundException e) {
            if (log.isErrorEnabled()) {
                log.error("findByUsername exception", e);
            }
        }

        return "profile";
    }
}
