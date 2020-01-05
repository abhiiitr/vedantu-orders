package com.vedantu.account.repository;

import org.springframework.stereotype.Component;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.common.exceptions.InvalidUserSession;

@Component
public interface AccountRepository {

	AccountEntity validateUserSession(String sessionId) throws InvalidUserSession;

}
