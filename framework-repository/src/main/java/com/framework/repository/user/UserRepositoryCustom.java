package com.framework.repository.user;

import com.framework.repository.base.BaseRepositoryCustom;

public interface UserRepositoryCustom extends BaseRepositoryCustom{

	boolean deleteUserWithChildren(String userId);
}
