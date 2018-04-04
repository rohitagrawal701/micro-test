package com.framework.repository.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.framework.collection.BaseCollection;

public class BaseRepositoryImpl implements BaseRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<? extends BaseCollection> findManyByQuery(Query query, Class<? extends BaseCollection> object) {
		return mongoTemplate.find(query, object.asSubclass(BaseCollection.class));
	}

	@Override
	public BaseCollection findOneByQuery(Query query, Class<? extends BaseCollection> object) {
		return mongoTemplate.findOne(query, object.asSubclass(BaseCollection.class));
	}

}
