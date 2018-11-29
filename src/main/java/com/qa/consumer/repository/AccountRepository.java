package com.qa.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.consumer.domain.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}
