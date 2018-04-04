package com.framework.repository.base;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.framework.collection.BaseCollection;

public interface BaseRepositoryCustom {

	List<? extends BaseCollection> findManyByQuery(Query query, Class<? extends BaseCollection> object);

	BaseCollection findOneByQuery(Query query, Class<? extends BaseCollection> object);
}
