package com.framework.controller.address;

import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.framework.annotation.collection.CascadeSave;
import com.framework.collection.Address;
import com.framework.dto.address.AddressDTO;
import com.framework.response.RESTResponse;
import com.framework.service.address.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/api/address", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public RESTResponse createAddress(@RequestBody AddressDTO addressDTO) {
		return RESTResponse.ok(addressService.insertAddress(addressDTO));
	}

	@RequestMapping(value = "/api/address/{address-id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public RESTResponse fetchAddressById(@PathVariable("address-id") String addressId) {
		return RESTResponse.ok(addressService.getAddressById(addressId));
	}

	@RequestMapping(value = "/api/address", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public RESTResponse fetchAllAddressForUser(@RequestParam("user-id") String userId) {
		return RESTResponse.ok(addressService.getAllAddressForUser(userId));
	}

	@RequestMapping(value = "/api/address/{address-id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public RESTResponse deleteAddress(@PathVariable("address-id") String addressId) {
		return RESTResponse.ok(addressService.deleteAddress(addressId));
	}

	public static void main(String[] args) {
		final Field[] fields = Address.class.getDeclaredFields();
		for (final Field field : fields) {
			if(field.isAnnotationPresent(CascadeSave.class)) {
				System.out.println(field.getType());
			}
		}
		//		final Class class1 = User.class;
		//		Method method = class1.getMethod("set"+Address.class.getSimpleName(), Address.class);
		//
		//		if (user.getAddress() != null) {
		//			user.getAddress().add(address);
		//		} else {
		//			user.setAddress(Arrays.asList(address));
		//		}
	}
}
