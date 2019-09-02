package cloud.oauth2.server.service.impl;

 
import cloud.oauth2.server.domain.AlreadyExistsException;
import cloud.oauth2.server.domain.JsonObjects;
import cloud.oauth2.server.domain.LoginHistory;
import cloud.oauth2.server.persistence.entity.LoginHistoryEntity;
import cloud.oauth2.server.persistence.repository.LoginHistoryRepository;
import cloud.oauth2.server.service.LoginHistoryService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Autowired
    LoginHistoryRepository loginHistoryRepository;

//    @Autowired
//    Mapper dozerMapper;

//    @Override
//    public JsonObjects<LoginHistory> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
//        JsonObjects<LoginHistory> jsonObjects = new JsonObjects<>();
//        Sort sort;
//        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
//            sort = new Sort(Sort.Direction.ASC, sortField);
//        } else {
//            sort = new Sort(Sort.Direction.DESC, sortField);
//        }
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
//        Page<LoginHistoryEntity> page = loginHistoryRepository.findByUsername(username, pageable);
//        if (page.getContent() != null && page.getContent().size() > 0) {
//            jsonObjects.setRecordsTotal(page.getTotalElements());
//            jsonObjects.setRecordsFiltered(page.getTotalElements());
//            page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, LoginHistory.class)));
/////         page.getContent().forEach(u -> jsonObjects.getData().add(BeanUtils.copyProperties(u, LoginHistory.class)));
//
//        }
//        return jsonObjects;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void asyncCreate(LoginHistory loginHistory) throws AlreadyExistsException {
//        LoginHistoryEntity entity = dozerMapper.map(loginHistory, LoginHistoryEntity.class);
        LoginHistoryEntity entity = new LoginHistoryEntity();
        BeanUtils.copyProperties(loginHistory, entity);
        loginHistoryRepository.save(entity);
    }
}
