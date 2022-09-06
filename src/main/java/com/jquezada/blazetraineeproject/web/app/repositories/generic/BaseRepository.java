package com.jquezada.blazetraineeproject.web.app.repositories.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.List;

public interface BaseRepository<T extends BaseModel> extends GenericRepository<T>, MongoRepository<T, String> {

//    MongoCollection getMongoCollection();
//
//    Iterable<T> iterator();
//
//    Iterable<T> getAllDeleted();
//
//    List<T> list();
//
//    List<T> listNonProductType();
//
//    List<T> listNonDeleted();
//
//    List<T> listNonDeleted(String projection);
//
//    List<T> listNonDeleted(List<ObjectId> ids);
//
//    HashMap<String, T> listAsMap();
//
//    HashMap<String, T> listAsMap(List<ObjectId> ids);
//
//    HashMap<String, T> listNonDeletedAsMap();
//
//    Iterable<T> findItemsIn(List<ObjectId> ids);
//    Iterable<T> findItemsIn(List<ObjectId> ids, String projection);
//
//    HashMap<String, T> findItemsInAsMap(List<ObjectId> ids);
//    HashMap<String, T> findItemsInAsMap(List<ObjectId> ids, String projection);
//
//    T getById(String entityId);
//    <E extends BaseModel> E getById(String entityId, Class<E> clazz);
//
//    T getById(String entityId, String projection);
//
//    T save(T model) throws Exception;
//
//    void hardRemoveById(List<ObjectId> objectIds);
//
//    T update(String entityId, T model) throws Exception;
//
//    T upsert(String entityId, T model) throws Exception;
//
//    boolean exist(String entityId);
//
//    List<T> save(List<T> models);
//
//    void removeById(String entityId);
//
//    void hardRemoveById(String entityId);
//
//    void updateModified(String entityId);
//
//    Long count();
//
//    Long countActive();
//
//    HashMap<String, T> listNonDeletedActiveAsMap();
//
//    HashMap<String, T> listNonDeletedActiveAsMap(String projection);
//
//    void hardRemoveByBeforeDate(long date);

}
