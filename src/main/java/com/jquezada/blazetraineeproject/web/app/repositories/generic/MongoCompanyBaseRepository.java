package com.jquezada.blazetraineeproject.web.app.repositories.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.CompanyBaseModel;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public interface MongoCompanyBaseRepository <T extends CompanyBaseModel> extends BaseRepository<T> {
//    Iterable<T> listBefore(long beforeDate);
//    Iterable<T> list(String companyId);
//
//    Iterable<T> listWithProjections(String companyId, String projection);
//
//    <E extends CompanyBaseModel> Iterable<E> list(String companyId, Class<E> clazz);
//
//    Iterable<T> listSort(String companyId, String sortOption);
//
//    Iterable<T> listWithOptions(String companyId, String projections);
//
//    HashMap<String, T> listAsMap(String companyId);
//
//    HashMap<String, T> listAsMapWithProjections(String companyId, String projection);
//
//    Iterable<T> listAll(String companyId);
//
//    HashMap<String, T> listAllAsMap(String companyId);
//
//    Iterable<T> listAllByShop(String companyId, String shopId);
//
//    HashMap<String, T> listAllByShopAsMap(String companyId, String shopId);
//
//    Iterable<T> listAllByShopById(String companyId, String shopId, String id);
//
//    HashMap<String, T> listAllByIdAsMap(String companyId, String shopId, String id);
//
//    Iterable<T> findItemsIn(String companyId, List<ObjectId> ids);
//
//    <E extends CompanyBaseModel> Iterable<E> findItemsIn(String companyId, List<ObjectId> ids, Class<E> clazz);
//
//    Iterable<T> findItemsIn(String companyId, List<ObjectId> ids, String projection);
//
//    HashMap<String, T> findItemsInAsMap(String companyId, List<ObjectId> ids);
//
//    Iterable<T> listWithDate(String companyId, long afterDate, long beforeDate);
//
//    Iterable<T> listWithDateWithOptions(String companyId, long afterDate, long beforeDate, String projections);
//
//    Iterable<T> list(String companyId, List<ObjectId> ids);
//
//    Iterable<T> list(List<ObjectId> ids, String projection);
//
//    Iterable<T> list(String companyId, List<ObjectId> ids, String projections);
//
//    HashMap<String, T> listAsMap(String companyId, List<ObjectId> ids);
//
//    HashMap<String, T> listAsMap(List<ObjectId> ids, String projection);
//
//    HashMap<String, T> listAsMap(String companyId, List<ObjectId> ids, String projections);
//
//    T get(String companyId, String id);
//
//    T get(String companyId, String id, String projection);
//
//    boolean exist(String companyId, String id);
//
//    <E extends CompanyBaseModel> E get(String companyid, String id, Class<E> clazz);
//
//    <E extends CompanyBaseModel> E getDefaultRegion(String companyId, Class<E> clazz);
//
//    long count(String companyId);
//
//    T update(String companyId, String entityId, T pojo);
//
//    void removeById(String companyId, String entityId);
//
//    void removeByIdSetState(String companyId, String entityId);
//
//    void removeAllSetState(String companyId);
//
//    Long countItemsIn(String companyId, List<ObjectId> documentIds);
//
//    Iterable<T> findItemsBySKU(String companyId, List<String> skus);
//
//    Iterable<T> getAllDeleted(String companyId, String projection);
}
