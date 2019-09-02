package cloud.oauth2.server.controller;



import cloud.oauth2.server.domain.GlobalConstant;
import cloud.oauth2.server.domain.JsonObjects;
import cloud.oauth2.server.domain.OauthClient;
import cloud.oauth2.server.domain.ResponseResult;
import cloud.oauth2.server.persistence.entity.OauthClientEntity;
import cloud.oauth2.server.persistence.repository.OauthClientRepository;
import cloud.oauth2.server.service.OauthClientService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/management/client")
public class ManageClientController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OauthClientService oauthClientService;
    
    @Autowired
    OauthClientRepository oauthClientRepository;


    @GetMapping(value = {"/", "", "/master"})
    public String master() {

        return "client/master";
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public  Page<OauthClientEntity>  listObjects(@RequestParam(value = "search[value]", required = false, defaultValue = "") String searchValue,
                                                @RequestParam(value = "draw", defaultValue = "0") int draw,
                                                @RequestParam(value = "length", defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "start", defaultValue = "0") Integer start,
                                                @RequestParam(value = "sidx", defaultValue = "id") String sortField,
                                                @RequestParam(value = "sord", defaultValue = "desc") String sortOrder) {
        int pageNum = start / 10 + 1;
//        JsonObjects<OauthClient> result = oauthClientService.list(pageNum, pageSize, sortField, sortOrder);
//        result.setDraw(draw + 1);
        
        
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = new Sort(Sort.Direction.ASC, sortField);
        } else {
            sort = new Sort(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
     
        Page<OauthClientEntity> page = oauthClientRepository.findAll(pageable);
       
        return page;
    }

    @GetMapping(value = "/details")
    @ResponseBody
    public OauthClient setupDetails(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "additionalData", required = false) String additionalData) {
    	OauthClient object = oauthClientService.retrieveById(id);
        object.setAdditionalData(additionalData);
        return object;
    }

    @PostMapping(value = "/details")
    @ResponseBody
    public ResponseResult<Object> handlePost(@RequestParam(value = "id", required = false) long id,
                                             @RequestParam(value = "deleteOperation", required = false, defaultValue = "1") int deleteOperation,
                                             @RequestParam(value = "clientId", required = false) String clientId,
                                             @RequestParam(value = "clientSecret", required = false) String clientSecret,
                                             @RequestParam(value = "authorities", required = false) String authorities,
                                             @RequestParam(value = "scope", required = false) String scope,
                                             @RequestParam(value = "authorizedGrantTypes", required = false) String authorizedGrantTypes,
                                             @RequestParam(value = "webServerRedirectUri", required = false) String webServerRedirectUri,
                                             @RequestParam(value = "remarks", required = false) String remarks) {

        ResponseResult<Object> responseResult = new ResponseResult<>();

        if (deleteOperation == -1 && id > 0) {
            oauthClientService.updateRecordStatus(id, 0);
            responseResult.setStatus(GlobalConstant.SUCCESS);
        } else if (deleteOperation == 0 && id > 0) {
            oauthClientService.updateRecordStatus(id, -1);
            responseResult.setStatus(GlobalConstant.SUCCESS);
        } else if (id > 0) {
            OauthClient object = oauthClientService.retrieveById(id);
            if (StringUtils.isNotEmpty(clientSecret)) {
                object.setClientSecret(passwordEncoder.encode(StringUtils.trim(clientSecret)));
            }
            if (StringUtils.isNotEmpty(authorities)) {
                object.setAuthorities(authorities);
            }
            if (StringUtils.isNotEmpty(scope)) {
                object.setScope(scope);
            }
            if (StringUtils.isNotEmpty(authorizedGrantTypes)) {
                object.setAuthorizedGrantTypes(authorizedGrantTypes);
            }
            if (StringUtils.isNotEmpty(webServerRedirectUri)) {
                object.setWebServerRedirectUri(webServerRedirectUri);
            }
            if (StringUtils.isNotEmpty(remarks)) {
                object.setRemarks(remarks);
            }
            oauthClientService.updateById(object);
        } else {
            if (StringUtils.isAnyEmpty(clientId, clientSecret, authorities, scope, authorizedGrantTypes, webServerRedirectUri)) {
                responseResult.setStatus(GlobalConstant.ERROR);
            } else {
                OauthClient object = new OauthClient();
                object.setClientId(clientId);
                object.setClientSecret(passwordEncoder.encode(StringUtils.trim(clientSecret)));
                object.setAuthorities(authorities);
                object.setScope(scope);
                object.setAuthorizedGrantTypes(authorizedGrantTypes);
                object.setWebServerRedirectUri(webServerRedirectUri);
                object.setRemarks(remarks);
                oauthClientService.create(object);
            }

        }

        return responseResult;
    }

}
