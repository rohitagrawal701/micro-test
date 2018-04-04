package com.framework.repository.address;

import com.framework.repository.base.BaseRepositoryCustom;

public interface AddressRepositoryCustom extends BaseRepositoryCustom{

	public boolean deleteAddressWithReference(String addressId);
}
