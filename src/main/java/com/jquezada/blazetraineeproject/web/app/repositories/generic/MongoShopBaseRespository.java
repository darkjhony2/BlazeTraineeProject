package com.jquezada.blazetraineeproject.web.app.repositories.generic;

import com.jquezada.blazetraineeproject.web.app.domain.generic.ShopBaseModel;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public interface MongoShopBaseRespository<T extends ShopBaseModel> extends MongoCompanyBaseRepository<T> {
//    void removeAllSetState(String companyId, String shopId);
//
//    T getLastModified(String companyId, String shopId);
//
//    long countItemsIn(String companyId, String shopId, List<ObjectId> ids);
//
//    Iterable<T> listByShop(String companyId, String shopId);
//
//    Iterable<T> listByShopAndPartnerId(String companyId, String shopId, String partnerId);
//
//    Iterable<T> listAllByShop(String companyId, String shopId);
//
//    Iterable<T> listAllByShopProjections(String companyId, String shopId, String projections);
//
//    Iterable<T> listAllByShopActive(String companyId, String shopId);
//
//    Iterable<T> listAllByShopActive(String companyId, String shopId, String projection);
//
//    Iterable<T> listByShopWithDates(String companyId, String shopId, long afterDate, long beforeDate);
//
//    Iterable<T> listByShopWithDatesCreate(String companyId, String shopId, long afterDate, long beforeDate);
//
//    boolean exist(String companyId, String shopId, String entityId);
//
//    long count(String companyId, String shopId);
//
//    HashMap<String, T> listAsMap(String companyId, String shopId);
//
//    HashMap<String, T> listAllByShopActiveAsMap(String companyId, String shopId);
//
//    HashMap<String, T> listAsMap(String companyId, String shopId, String projection);
//
//    Iterable<T> listByShopWithProjection(String companyId, String shopId, String projection);
//
//    Iterable<T> listByShopWithProjection(String companyId, String shopId, int skip, int limit, String projection);
//
//    HashMap<String, T> listAllAsMap(String companyId, String shopId);
//
//    HashMap<String, T> findItemsInAsMap(String companyId, String shopId, List<ObjectId> ids);
//
//    Iterable<T> findItemsIn(String companyId, String shopId, List<ObjectId> ids);
//
//    HashMap<String, T> findItemsInAsMap(String companyId, String shopId, List<ObjectId> ids, String projection);
//    Iterable<T> findItemsIn(String companyId, String shopId, List<ObjectId> ids, String projection);
//
//    Iterable<T> listByShopSort(String companyId, String shopId, String sortOptions, int skip, int limit);
//
//    Iterable<T> listByShop(String companyId, String shopId, int skip, int limit);
//
//    Iterable<T> listByShopWithDate(String companyId, String shopId, long afterDate, long beforeDate);
//
//    Iterable<T> listByShopWithDateSort(String companyId, String shopId, String sortOptions, long afterDate, long beforeDate);
//
//    Iterable<T> listByShopWithCreatedDateSort(String companyId, String shopId, String sortOptions, long afterDate, long beforeDate);
//
//    Iterable<T> listByShop(String companyId, String shopId, String sortField);
//
//    Iterable<T> listAllByShop(String companyId, String shopId, String sortField);
//
//    Iterable<T> listByShopSort(String companyId, String shopId, String sortOptions);
//
//    T getByShopAndId(String companyId, String shopId, String entityId);
//
//    long countItems(String companyId, String shopId);
}
