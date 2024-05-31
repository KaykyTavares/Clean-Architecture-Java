package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.CreateUserGateway;
import br.com.course.core.domain.TransectionPin;
import br.com.course.core.domain.User;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.EmailException;
import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.TransectionPinException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private EmailAvailableUseCase emailAvailableUseCase;
    private CreateUserGateway createUserGateway;
    private CreateWalletUseCase createWalletUseCase;
    private CreateTransectionPinUseCase createTransectionPinUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway, CreateWalletUseCase createWalletUseCase, CreateTransectionPinUseCase createTransectionPinUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransectionPinUseCase = createTransectionPinUseCase;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransectionPinException {
        if(!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        User createdUser = createUserGateway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, createdUser));
        createTransectionPinUseCase.create(new TransectionPin(createdUser, pin));
    }
}

