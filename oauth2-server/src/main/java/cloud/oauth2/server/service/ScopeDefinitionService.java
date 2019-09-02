package cloud.oauth2.server.service;

import cloud.oauth2.server.domain.NotImplementException;
import cloud.oauth2.server.domain.ScopeDefinition;

public interface ScopeDefinitionService extends CommonServiceInterface<ScopeDefinition> {
    default ScopeDefinition findByScope(String scope) throws NotImplementException {
        throw new NotImplementException();
    }
}
