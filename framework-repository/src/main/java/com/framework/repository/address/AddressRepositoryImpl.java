package com.framework.repository.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.framework.collection.Address;
import com.framework.collection.User;
import com.framework.repository.base.BaseRepositoryImpl;

public class AddressRepositoryImpl extends BaseRepositoryImpl implements AddressRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean deleteAddressWithReference(String addressId) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(addressId)), Address.class);
		mongoTemplate.updateFirst(new Query(), new Update().pull("address.id", addressId), User.class);
		return true;
	}

}
