package com.vedantu.account.service;

import org.springframework.stereotype.Service;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.common.exceptions.InvalidUserSession;

@Service
public interface AccountService {

	AccountEntity validateUserSession(String sessionId) throws InvalidUserSession;

}
