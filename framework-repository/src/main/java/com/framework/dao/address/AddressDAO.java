package com.framework.dao.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.framework.collection.Address;
import com.framework.repository.address.AddressRepository;

@Repository
public class AddressDAO {

	@Autowired
	AddressRepository addressRepository;

	public Address insertAddress(Address address) {
		addressRepository.insert(address);
		return address;
	}

	public Address getAddressById(String addressId) {
		return addressRepository.findOne(addressId);
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddressForUser(String userId) {
		return (List<Address>) addressRepository.findManyByQuery(new Query(Criteria.where("user.id").is(userId)),
				Address.class);
	}

	public boolean deleteAddress(String addressId) {
		return addressRepository.deleteAddressWithReference(addressId);
	}
}
