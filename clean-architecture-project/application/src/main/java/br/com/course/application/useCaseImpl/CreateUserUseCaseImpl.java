package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.CreateUserGateway;
import br.com.course.core.domain.TransectionPin;
import br.com.course.core.domain.User;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.EmailException;
import br.com.course.core.exception.InternalServerErrorException;
import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.TransectionPinException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransectionPinException, InternalServerErrorException {
        if(!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user), new TransectionPin(user, pin))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}

