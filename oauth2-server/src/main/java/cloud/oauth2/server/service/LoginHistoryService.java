package cloud.oauth2.server.service;

import cloud.oauth2.server.domain.JsonObjects;
import cloud.oauth2.server.domain.LoginHistory;

public interface LoginHistoryService extends CommonServiceInterface<LoginHistory> {
//    JsonObjects<LoginHistory> listByUsername(String username, int pageNum,
//                                             int pageSize,
//                                             String sortField,
//                                             String sortOrder);
    
    void asyncCreate(LoginHistory loginHistory);

}
