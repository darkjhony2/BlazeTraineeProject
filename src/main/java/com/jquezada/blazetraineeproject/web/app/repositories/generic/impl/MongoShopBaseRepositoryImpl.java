//package com.jquezada.blazetraineeproject.web.app.repositories.generic.impl;
//
//import com.jquezada.blazetraineeproject.web.app.domain.db.MongoDb;
//import com.jquezada.blazetraineeproject.web.app.domain.generic.ShopBaseModel;
//import com.jquezada.blazetraineeproject.web.app.repositories.generic.MongoShopBaseRespository;
//import org.bson.types.ObjectId;
//import org.joda.time.DateTime;
//import org.springframework.util.StringUtils;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class MongoShopBaseRepositoryImpl<T extends ShopBaseModel> extends MongoCompanyBaseRepositoryImpl<T> implements MongoShopBaseRespository<T> {
//
//    public MongoShopBaseRepositoryImpl(Class<T> clazz, MongoDb mongoManager) throws Exception {
//        super(clazz, mongoManager);
//    }
//
//    @Override
//    public void removeAllSetState(String companyId, String shopId) {
//        coll.update("{companyId:#,shopId:#}", companyId, shopId).multi().with("{$set: {deleted:true,active:false,modified:#}}", DateTime.now().getMillis());
//    }
//
//    @Override
//    public T getLastModified(String companyId, String shopId) {
//        Iterable<T> items =  coll.find("{companyId:#,shopId:#}",companyId,shopId).sort("{modified:-1}").limit(1).as(entityClazz);
//        for (T item : items) {
//            return item;
//        }
//        return null;
//    }
//
//    @Override
//    public T getByShopAndId(String companyId, String shopId, String entityId) {
//        if (StringUtils.isEmpty(companyId) || StringUtils.isEmpty(shopId) || StringUtils.isEmpty(entityId)) {
//            return null;
//        }
//        return coll.findOne("{companyId: #,shopId:#,_id:#}", companyId, shopId, new ObjectId(entityId)).as(entityClazz);
//    }
//
//    @Override
//    public boolean exist(String companyId, String shopId, String entityId) {
//        if (StringUtils.isEmpty(companyId) || StringUtils.isEmpty(shopId) || StringUtils.isEmpty(entityId)) {
//            return false;
//        }
//        return coll.findOne("{companyId: #,shopId:#,_id:#}", companyId, shopId, new ObjectId(entityId))
//                .projection("{_id: 1}")
//                .as(entityClazz) != null;
//    }
//
//
//    @Override
//    public long count(String companyId, String shopId) {
//        return coll.count("{companyId: #,shopId:#,deleted:false}", companyId, shopId);
//    }
//
//    @Override
//    public long countItemsIn(String companyId, String shopId, List<ObjectId> ids) {
//        return coll.count("{companyId:#,shopId:#,_id:{$in:#}}", companyId, shopId, ids);
//    }
//
//    @Override
//    public Iterable<T> listByShop(String companyId, String shopId) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopAndPartnerId(String companyId, String shopId, String partnerId) {
//        return coll.find("{companyId: #,shopId:#, partnerId:#, deleted:false}", companyId, shopId, partnerId).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShop(String companyId, String shopId, int skip, int limit) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId).skip(skip).limit(limit).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopWithDate(String companyId, String shopId, long afterDate, long beforeDate) {
//        Iterable<T> items = coll.find("{companyId:#,shopId:#, modified:{$lt:#, $gt:#}}", companyId, shopId, beforeDate, afterDate).as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> listByShopWithDateSort(String companyId, String shopId, String sortOptions, long afterDate, long beforeDate) {
//        Iterable<T> items = coll.find("{companyId:#,shopId:#, modified:{$lt:#, $gt:#}}", companyId, shopId, beforeDate, afterDate).sort(sortOptions).as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> listByShopWithCreatedDateSort(String companyId, String shopId, String sortOptions, long afterDate, long beforeDate) {
//        Iterable<T> items = coll.find("{companyId:#,shopId:#, created:{$lt:#, $gt:#}, deleted:false}", companyId, shopId, beforeDate, afterDate).sort(sortOptions).as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> listByShop(String companyId, String shopId, String sortField) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId).sort("{" + sortField + ":1}").as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopSort(String companyId, String shopId, String sortOptions) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId).sort(sortOptions).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopSort(String companyId, String shopId, String sortOptions, int skip, int limit) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId).sort(sortOptions).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listAllByShop(String companyId, String shopId, String sortField) {
//        return coll.find("{companyId: #,shopId:#}", companyId, shopId).sort("{" + sortField + ":1}").as(entityClazz);
//    }
//
//    @Override
//    public HashMap<String, T> listAsMap(String companyId, String shopId) {
//        Iterable<T> items = listByShop(companyId, shopId);
//        return asMap(items);
//    }
//
//    @Override
//
//    public HashMap<String, T> listAllByShopActiveAsMap(String companyId, String shopId) {
//        Iterable<T> items = listAllByShopActive(companyId, shopId);
//        return asMap(items);
//    }
//    public HashMap<String, T> listAsMap(String companyId, String shopId, String projection) {
//        Iterable<T> items = listByShopWithProjection(companyId, shopId, projection);
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> listByShopWithProjection(String companyId, String shopId, String projection) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId)
//                .projection(projection)
//                .as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopWithProjection(String companyId, String shopId, int skip, int limit, String projection) {
//        return coll.find("{companyId: #,shopId:#,deleted:false}", companyId, shopId)
//                .skip(skip)
//                .limit(limit)
//                .projection(projection)
//                .as(entityClazz);
//    }
//
//    @Override
//    public HashMap<String, T> listAllAsMap(String companyId, String shopId) {
//        Iterable<T> items = listAllByShop(companyId, shopId);
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> listAllByShopById(String companyId, String shopId, String id) {
//        return coll.find("{companyId: #,shopId:#, _id:#}", companyId, shopId, new ObjectId(id)).as(entityClazz);
//    }
//
//    @Override
//    public HashMap<String, T> listAllByIdAsMap(String companyId, String shopId, String id) {
//        Iterable<T> items = listAllByShopById(companyId, shopId, id);
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> listAllByShop(String companyId, String shopId) {
//        return coll.find("{companyId: #,shopId:#}", companyId, shopId).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listAllByShopProjections(String companyId, String shopId, String projections) {
//        return coll.find("{companyId: #,shopId:#}", companyId, shopId).projection(projections).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listAllByShopActive(String companyId, String shopId) {
//        return coll.find("{companyId: #,shopId:#,deleted:false,active:true}", companyId, shopId).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listAllByShopActive(String companyId, String shopId, String projection) {
//        return coll.find("{companyId: #,shopId:#,deleted:false,active:true}", companyId, shopId)
//                .projection(projection)
//                .as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> listByShopWithDates(String companyId, String shopId, long afterDate, long beforeDate) {
//        Iterable<T> items = coll.find("{companyId:#,shopId:#, deleted: false, modified:{$lt:#, $gt:#}}",
//                companyId, shopId,
//                beforeDate, afterDate).as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> listByShopWithDatesCreate(String companyId, String shopId, long afterDate, long beforeDate) {
//        Iterable<T> items = coll.find("{companyId:#,shopId:#, deleted: false, created:{$lt:#, $gt:#}}",
//                companyId, shopId,
//                beforeDate, afterDate).as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> findItemsIn(String companyId, String shopId, List<ObjectId> ids) {
//        return coll.find("{companyId:#,shopId:#,_id:{$in:#}}", companyId, shopId, ids).as(entityClazz);
//    }
//
//
//    @Override
//    public HashMap<String, T> findItemsInAsMap(String companyId, String shopId, List<ObjectId> ids) {
//        Iterable<T> items = findItemsIn(companyId, shopId, ids);
//
//        return asMap(items);
//    }
//
//    @Override
//    public HashMap<String, T> findItemsInAsMap(String companyId, String shopId, List<ObjectId> ids, String projection) {
//        Iterable<T> items = findItemsIn(companyId, shopId, ids, projection);
//
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> findItemsIn(String companyId, String shopId, List<ObjectId> ids, String projection) {
//        return coll.find("{companyId:#,shopId:#,_id:{$in:#}}", companyId, shopId, ids).projection(projection).as(entityClazz);
//    }
//
//    @Override
//    public long countItems(String companyId, String shopId) {
//        return coll.count("{companyId:#,shopId:#,deleted:false}", companyId, shopId);
//    }
//
//}
