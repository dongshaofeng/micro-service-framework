package cloud.oauth2.server.service.impl;
 

import cloud.oauth2.server.domain.NotImplementException;
import cloud.oauth2.server.domain.ScopeDefinition;
import cloud.oauth2.server.persistence.entity.ScopeDefinitionEntity;
import cloud.oauth2.server.persistence.repository.ScopeDefinitionRepository;
import cloud.oauth2.server.service.ScopeDefinitionService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeDefinitionServiceImpl implements ScopeDefinitionService {

    @Autowired
    ScopeDefinitionRepository scopeDefinitionRepository;
 

    @Override
    public ScopeDefinition findByScope(String scope) throws NotImplementException {
        ScopeDefinitionEntity scopeDefinitionEntity = scopeDefinitionRepository.findByScope(scope);
        ScopeDefinition scopeDefinition = new ScopeDefinition();
        if (scopeDefinitionEntity != null) {
    	       BeanUtils.copyProperties(scopeDefinitionEntity,scopeDefinition); 

            return scopeDefinition;
        } else {
            return null;
        }
    }

}
