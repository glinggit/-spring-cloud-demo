package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;

public class UserFeignClientFallBack implements UserFeignClient {

	@Override
	public User findById(Long id) {
		return new User("error for findById");
	}

	@Override
	public User postUser(User user) {
		return new User("error for postUser");
	}

	@Override
	public User getUser(User user) {
		return new User("error for getUser");
	}

}
