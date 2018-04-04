package com.framework.repository.address;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.framework.collection.Address;

public interface AddressRepository extends MongoRepository<Address, String>, AddressRepositoryCustom{

}
