package cloud.oauth2.server.service.impl;
 
import cloud.oauth2.server.domain.AlreadyExistsException;
import cloud.oauth2.server.domain.EntityNotFoundException;
import cloud.oauth2.server.domain.JsonObjects;
import cloud.oauth2.server.domain.OauthClient;
import cloud.oauth2.server.persistence.entity.OauthClientEntity;
import cloud.oauth2.server.persistence.repository.OauthClientRepository;
import cloud.oauth2.server.service.OauthClientService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired
    OauthClientRepository oauthClientRepository;

 
    @Override
    public OauthClient findByClientId(String clientId) {
        OauthClientEntity oauthClientEntity = oauthClientRepository.findByClientId(clientId);
        if (oauthClientEntity != null) {
         	OauthClient oauthClient = new OauthClient();
        	    BeanUtils.copyProperties(oauthClientEntity,oauthClient);
            return oauthClient;
        } else {
            return null;
        }
    }

    @Override
    public  JsonObjects<OauthClient> list(int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<OauthClient> jsonObjects = new JsonObjects<>();
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = new Sort(Sort.Direction.ASC, sortField);
        } else {
            sort = new Sort(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
     
        Page<OauthClientEntity> page = oauthClientRepository.findAll(pageable);
        if (page.getContent() != null && page.getContent().size() > 0) {
            jsonObjects.setRecordsTotal(page.getTotalElements());
            jsonObjects.setRecordsFiltered(page.getTotalElements());
//            page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, OauthClient.class)));
       
        }
        
        
        return jsonObjects;
    }

    @Override
    public OauthClient create(OauthClient oauthClient) throws AlreadyExistsException {
        OauthClientEntity exist = oauthClientRepository.findByClientId(oauthClient.getClientId());
        if (exist != null) {
            throw new AlreadyExistsException(oauthClient.getClientId() + " already exists!");
        }
        OauthClientEntity oauthClientEntity =new OauthClientEntity ();
//        ?dozerMapper.map(oauthClient, OauthClientEntity.class);
        
        BeanUtils.copyProperties(oauthClient,oauthClientEntity);
        oauthClientRepository.save(oauthClientEntity);
        return oauthClient;
    }

    @Override
    public OauthClient retrieveById(long id) throws EntityNotFoundException {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(id);
        OauthClient oauthClient = new OauthClient();
        BeanUtils.copyProperties(entityOptional.orElseThrow(EntityNotFoundException::new),oauthClient);
        return oauthClient;
    }

    @Override
    public OauthClient updateById(OauthClient oauthClient) throws EntityNotFoundException {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(oauthClient.getId());
        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        if (StringUtils.isNotEmpty(oauthClient.getClientSecret())) {
            e.setClientSecret(oauthClient.getClientSecret());
        }
        e.setAuthorities(oauthClient.getAuthorities());
        e.setScope(oauthClient.getScope());
        e.setAuthorizedGrantTypes(oauthClient.getAuthorizedGrantTypes());
        e.setWebServerRedirectUri(oauthClient.getWebServerRedirectUri());

        if (StringUtils.isNotEmpty(oauthClient.getRemarks())) {
            e.setRemarks(oauthClient.getRemarks());
        }

        oauthClientRepository.save(e);
        BeanUtils.copyProperties(e,oauthClient);

        return oauthClient;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRecordStatus(long id, int recordStatus) {
        Optional<OauthClientEntity> entityOptional = oauthClientRepository.findById(id);
        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
        e.setRecordStatus(recordStatus);
        oauthClientRepository.save(e);
    }
}
