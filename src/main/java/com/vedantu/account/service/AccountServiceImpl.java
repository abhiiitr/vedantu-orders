package com.vedantu.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.account.repository.AccountRepository;
import com.vedantu.common.exceptions.InvalidUserSession;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity validateUserSession(String sessionId) throws InvalidUserSession {
		AccountEntity accountEntity = accountRepository.validateUserSession(sessionId);
		return accountEntity;
	}

}
