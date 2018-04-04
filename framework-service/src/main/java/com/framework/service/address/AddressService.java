package com.framework.service.address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.collection.Address;
import com.framework.collection.User;
import com.framework.dao.address.AddressDAO;
import com.framework.dao.user.UserDAO;
import com.framework.dto.address.AddressDTO;

@Service
public class AddressService {

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Autowired
	AddressDAO addressDAO;

	@Autowired
	UserDAO userDAO;

	public AddressDTO insertAddress(AddressDTO addressDTO) {
		Address address = new Address();
		dozerBeanMapper.map(addressDTO, address, "address-create-complete");
		final User user = userDAO.getUserById(addressDTO.getUserId());
		address.setUser(user);
		addressDAO.insertAddress(address);
		if (user.getAddress() != null) {
			user.getAddress().add(address);
		} else {
			user.setAddress(Arrays.asList(address));
		}
		userDAO.insertUser(user);
		dozerBeanMapper.map(address, addressDTO);
		return addressDTO;

	}

	public AddressDTO getAddressById(String addressId) {
		final Address address = addressDAO.getAddressById(addressId);
		final AddressDTO addressDTO = new AddressDTO();
		dozerBeanMapper.map(address, addressDTO);
		return addressDTO;
	}

	public List<AddressDTO> getAllAddressForUser(String userId) {
		final List<Address> addressList = addressDAO.getAllAddressForUser(userId);
		final List<AddressDTO> addressDTOList = new ArrayList<>();
		for (final Address address : addressList) {
			final AddressDTO addressDTO = new AddressDTO();
			dozerBeanMapper.map(address, addressDTO);
			addressDTOList.add(addressDTO);
		}
		return addressDTOList;
	}

	public boolean deleteAddress(String addressId) {
		return addressDAO.deleteAddress(addressId);
	}

}
