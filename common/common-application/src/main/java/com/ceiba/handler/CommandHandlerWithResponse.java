package com.ceiba.handler;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandlerWithResponse<C, R> {

	@Transactional
	R execute(C command);
}
