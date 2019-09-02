package cloud.oauth2.server.service;

import cloud.oauth2.server.domain.NotImplementException;
import cloud.oauth2.server.domain.OauthClient;

public interface OauthClientService extends CommonServiceInterface<OauthClient> {
    default OauthClient findByClientId(String clientId){
        throw new NotImplementException();
    }
}
