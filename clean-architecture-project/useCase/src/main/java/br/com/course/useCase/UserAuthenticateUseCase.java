package br.com.course.useCase;

import br.com.course.core.exception.AuthenticationException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String userName, String password) throws AuthenticationException;
}
