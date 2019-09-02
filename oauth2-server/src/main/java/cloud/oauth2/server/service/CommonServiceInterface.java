package cloud.oauth2.server.service;


import cloud.oauth2.server.domain.AlreadyExistsException;
import cloud.oauth2.server.domain.EntityNotFoundException;
import cloud.oauth2.server.domain.JsonObjects;
import cloud.oauth2.server.domain.NotImplementException;

public interface CommonServiceInterface<T> {


    default JsonObjects<T> list(int pageNum,
                                int pageSize,
                                String sortField,
                                String sortOrder) {
        throw new NotImplementException();
    }

    default T create(T t) throws AlreadyExistsException {
        throw new NotImplementException();
    }

    default T retrieveById(long id) throws EntityNotFoundException {
        throw new NotImplementException();
    }

    default T updateById(T t) throws EntityNotFoundException {
        throw new NotImplementException();
    }

    default void deleteById(long id) {
        throw new NotImplementException();
    }

    default void updateRecordStatus(long id, int recordStatus) {
        throw new NotImplementException();
    }
}
