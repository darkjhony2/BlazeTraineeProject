//package com.jquezada.blazetraineeproject.web.app.repositories.generic.impl;
//
//import com.google.common.collect.Lists;
//import com.jquezada.blazetraineeproject.web.app.domain.annotations.CollectionName;
//import com.jquezada.blazetraineeproject.web.app.domain.db.MongoDb;
//import com.jquezada.blazetraineeproject.web.app.domain.generic.BaseModel;
//import com.jquezada.blazetraineeproject.web.app.repositories.generic.BaseRepository;
//import com.mongodb.DB;
//import org.bson.types.ObjectId;
//import org.jongo.Jongo;
//import org.jongo.MongoCollection;
//
//import org.joda.time.DateTime;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class MongoBaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {
//
//    final MongoDb mongoManager;
//
//    protected final MongoCollection coll;
//    protected final Class<T> entityClazz;
//    protected CollectionName collectionName;
//
//    public MongoBaseRepositoryImpl(Class<T> clazz, MongoDb mongoManager) throws Exception {
//        this.mongoManager = mongoManager;
//        collectionName = clazz.getAnnotation(CollectionName.class);
//        coll = mongoManager.getJongoCollection(collectionName.name());
//        entityClazz = clazz;
//
//        // check for indexes
//        /*String[] indexes = collectionName.indexes();
//        for(String index : indexes) {
//            coll.ensureIndex(index);
//        }
//
//        String[] uniqueIndexes = collectionName.uniqueIndexes();
//        for(String index : uniqueIndexes) {
//            coll.ensureIndex(index,"{unique:true}");
//        }*/
//    }
//
//    public Jongo getJongo() {
//        try {
//            return mongoManager.getJongo();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    protected DB getDB() {
//        try {
//            return mongoManager.getDB();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public MongoCollection getMongoCollection() {
//        return coll;
//    }
//
//    @Override
//    public List<T> list() {
//        Iterable<T> items = coll.find().as(entityClazz);
//        return Lists.newArrayList(items);
//    }
//
//    public List<T> listNonProductType() {
//        Iterable<T> items = coll.find("{productSaleType: { $exists: # }}", false).as(entityClazz);
//        return Lists.newArrayList(items);
//    }
//
//    @Override
//    public List<T> listNonDeleted() {
//        Iterable<T> items = coll.find("{deleted:false}").as(entityClazz);
//        return Lists.newArrayList(items);
//    }
//
//    @Override
//    public List<T> listNonDeleted(String projection) {
//        Iterable<T> items = coll.find("{deleted:false}")
//                .projection(projection)
//                .as(entityClazz);
//        return Lists.newArrayList(items);
//    }
//
//    @Override
//    public List<T> listNonDeleted(List<ObjectId> ids) {
//        Iterable<T> items = coll.find("{deleted:false, _id:{$in:#}}", ids).as(entityClazz);
//        return Lists.newArrayList(items);
//    }
//
//    @Override
//    public HashMap<String, T> listNonDeletedAsMap() {
//        Iterable<T> items = listNonDeleted();
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> iterator() {
//        Iterable<T> items = coll.find().as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public Iterable<T> getAllDeleted() {
//        Iterable<T> items = coll.find("{deleted:true}").as(entityClazz);
//        return items;
//    }
//
//    @Override
//    public HashMap<String, T> listAsMap() {
//        Iterable<T> items = list();
//        return asMap(items);
//    }
//
//    @Override
//    public HashMap<String, T> listAsMap(List<ObjectId> ids) {
//        Iterable<T> items = listNonDeleted(ids);
//        return asMap(items);
//    }
//
//    @Override
//    public Iterable<T> findItemsIn(List<ObjectId> ids) {
//        return coll.find("{_id:{$in:#}}", ids).as(entityClazz);
//    }
//
//    @Override
//    public Iterable<T> findItemsIn(List<ObjectId> ids, String projection) {
//        return coll.find("{_id:{$in:#}}", ids).projection(projection).as(entityClazz);
//    }
//
//    @Override
//    public HashMap<String, T> findItemsInAsMap(List<ObjectId> ids) {
//        return asMap(findItemsIn(ids));
//    }
//
//    @Override
//    public HashMap<String, T> findItemsInAsMap(List<ObjectId> ids, String projection) {
//        return asMap(findItemsIn(ids,projection));
//    }
//
//    protected HashMap<String, T> asMap(Iterable<T> items) {
//        HashMap<String, T> map = new HashMap<>();
//        for (T item : items) {
//            map.put(item.getId(), item);
//        }
//        return map;
//    }
//
//    @Override
//    public List<T> save(List<T> models) {
//        if (models == null || models.size() == 0) {
//            return models;
//        }
//        coll.insert(models.toArray());
//        return models;
//    }
//
//
//    @Override
//    public T upsert(String entityId, T model) throws Exception {
//        if (entityId == null || !ObjectId.isValid(entityId) || model == null) {
//            throw new Exception("POJO should not be null.");
//        }
//        Object id = null;
//        if (entityId != null) {
//            model.setModified(DateTime.now().getMillis());
//            id = coll.update(new ObjectId(entityId)).upsert().with(model).getUpsertedId();
//
//        } else {
//            id = coll.save(model).getUpsertedId();
//        }
//
//        if (id != null && id instanceof ObjectId) {
//            model.setId(id.toString());
//        }
//        return model;
//    }
//
//    @Override
//    public void removeById(String entityId) {
//        if (entityId != null && ObjectId.isValid(entityId)) {
//            // Fake Delete
//            coll.update(new ObjectId(entityId)).with("{$set: {deleted:true,modified:#}}", DateTime.now().getMillis());
//        }
//    }
//
//    @Override
//    public void hardRemoveById(String entityId) {
//        if (entityId != null && ObjectId.isValid(entityId)) {
//            coll.remove(new ObjectId(entityId));
//        }
//    }
//
//    @Override
//    public void hardRemoveById(List<ObjectId> objectIds) {
//        if (objectIds != null && !objectIds.isEmpty()) {
//            coll.remove("{_id: {$in:#}}", objectIds);
//        }
//    }
//
//    @Override
//    public void updateModified(String entityId) {
//        if (entityId != null && ObjectId.isValid(entityId)) {
//            coll.update(new ObjectId(entityId)).with("{$set: {modified:#}}", DateTime.now().getMillis());
//        }
//    }
//
//    public T update(String entityId, T pojo) throws Exception {
//        if (entityId == null || !ObjectId.isValid(entityId) || pojo == null) {
//            throw new Exception("POJO should not be null.");
//        }
//        pojo.setModified(DateTime.now().getMillis());
//        coll.update(new ObjectId(entityId)).with(pojo);
//        return pojo;
//    }
//
//
//    public T getById(String id) {
//        if (id == null || !ObjectId.isValid(id)) {
//            return null;
//        }
//        return coll.findOne(new ObjectId(id)).as(entityClazz);
//    }
//
//    @Override
//    public <E extends BaseModel> E getById(String entityId, Class<E> clazz) {
//        if (entityId == null || !ObjectId.isValid(entityId)) {
//            return null;
//        }
//        return coll.findOne(new ObjectId(entityId)).as(clazz);
//    }
//
//    @Override
//    public T getById(String entityId, String projection) {
//        if (entityId == null || !ObjectId.isValid(entityId)) {
//            return null;
//        }
//        return coll.findOne(new ObjectId(entityId)).projection(projection).as(entityClazz);
//    }
//
//    @Override
//    public T save(T model) throws Exception {
//        if (model == null) {
//            throw new Exception("POJO should not be null.");
//        }
//        Object id = coll.save(model).getUpsertedId();
//        if (id instanceof ObjectId) {
//            model.setId(id.toString());
//        }
//        return model;
//    }
//
//    public boolean exist(String id) {
//        if (id == null || !ObjectId.isValid(id)) {
//            return false;
//        }
//        long count = coll.count("{_id:#}", new ObjectId(id));
//        return count > 0;
//    }
//
//    @Override
//    public Long count() {
//        return coll.count();
//    }
//
//    @Override
//    public Long countActive() {
//        return coll.count("{deleted:false, active:true}");
//    }
//
//    public void dropCollection() {
//        coll.drop();
//    }
//
//    @Override
//    public HashMap<String, T> listNonDeletedActiveAsMap() {
//        Iterable<T> items = coll.find("{deleted:false,active:true}").as(entityClazz);
//        return asMap(items);
//    }
//
//    @Override
//    public HashMap<String, T> listNonDeletedActiveAsMap(String projection) {
//        Iterable<T> items = coll.find("{deleted:false,active:true}")
//                .projection(projection)
//                .as(entityClazz);
//        return asMap(items);
//    }
//
//    @Override
//    public void hardRemoveByBeforeDate(long date) {
//        if (date != 0l) {
//            coll.remove("{created: {$lt:#}}", date);
//        }
//    }
//}
