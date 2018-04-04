package com.framework.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.framework.collection.Address;
import com.framework.collection.User;
import com.framework.repository.base.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean deleteUserWithChildren(String userId) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(userId)), User.class);
		mongoTemplate.remove(new Query(Criteria.where("user.id").is(userId)), Address.class);
		return true;
	}

}
