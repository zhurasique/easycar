package com.service.account.client;

import com.service.account.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth")
public interface AuthServiceClient {

	@RequestMapping(method = RequestMethod.POST, value = "/uaa/user", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void createUser(User user);

}
