package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.TransferGateway;
import br.com.course.core.domain.Transaction;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.InternalServerErrorException;
import br.com.course.core.exception.TransferException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.CreateTransactionUseCase;
import br.com.course.useCase.FindWalletByTaxNumberUseCase;
import br.com.course.useCase.TransactionValidateUseCase;
import br.com.course.useCase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private TransactionValidateUseCase transactionValidateUseCase;
    private CreateTransactionUseCase createTransactionUseCase;
    private TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException {
        Wallet fromWallet = findWalletByTaxNumberUseCase.findByTaxNumber(fromTaxNumber);
        Wallet toWallet = findWalletByTaxNumberUseCase.findByTaxNumber(toTaxNumber);

        fromWallet.transfer(value);
        toWallet.receiveValue(value);

        Transaction transaction = createTransactionUseCase.create(new Transaction(fromWallet, toWallet, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.tranfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
