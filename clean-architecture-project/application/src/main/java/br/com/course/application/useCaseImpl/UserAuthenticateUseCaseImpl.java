package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.UserAuthenticateGateway;
import br.com.course.core.exception.AuthenticationException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String userName, String password) throws AuthenticationException {
        if (!userAuthenticateGateway.authenticate(userName, password)){
            throw new AuthenticationException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }

        return true;
    }
}
