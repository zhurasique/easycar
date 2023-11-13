package com.easycar.account.client;

import com.easycar.account.vo.Exists;
import com.easycar.account.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth")
@RequestMapping("/uaa/user")
public interface AuthServiceClient {

	@RequestMapping(method = RequestMethod.POST)
	void createUser(User user);

	@RequestMapping(path = "/exists/{id}", method = RequestMethod.GET)
	Exists isUserExists(@PathVariable String id);
}
