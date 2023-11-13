package com.easycar.account.repository;

import com.easycar.account.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepo extends MongoRepository<Account, String> {
}
