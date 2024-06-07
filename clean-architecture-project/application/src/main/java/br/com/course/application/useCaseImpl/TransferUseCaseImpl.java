package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.TransferGateway;
import br.com.course.core.domain.Transaction;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.InternalServerErrorException;
import br.com.course.core.exception.NotFoundException;
import br.com.course.core.exception.NotificationException;
import br.com.course.core.exception.TransferException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;
    private UserNotificationUseCase userNotificationUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway, UserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException {
        Wallet fromWallet = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet toWallet = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        fromWallet.transfer(value);
        toWallet.receiveValue(value);

        Transaction transaction = createTransactionUseCase.create(new Transaction(fromWallet, toWallet, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.tranfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, toWallet.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
