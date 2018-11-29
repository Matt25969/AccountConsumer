package com.qa.consumer.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.transfer.DTO.Account;

//import com.qa.consumer.domain.Account;

@Component
public class AccountReceiver {

	@Autowired
	private MongoRepository mongoRepo;

	private int accountCount = 1;

//	@JmsListener(destination = "accountQueue", containerFactory = "myFactory")
//	public void receiveMessage(Account account) {
//		String accountMessage = "<" + accountCount + "> Received <" + account + ">";
//		System.out.println(accountMessage);
//		accountCount++;
//		mongoRepo.insert(account);
//	}
	
	@JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
	public void receiveMessage(Account account) {
		String accountMessage = "<" + accountCount + "> Received <" + account + ">";
		System.out.println(accountMessage);
		accountCount++;
		account.setAccountID(accountCount);
		account.setDate(Date.valueOf(LocalDate.now()));
		mongoRepo.insert(account);
	}

}
