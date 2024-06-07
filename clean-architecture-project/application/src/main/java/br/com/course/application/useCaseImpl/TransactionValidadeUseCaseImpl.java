package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.TransactionValidadeGateway;
import br.com.course.core.domain.Transaction;
import br.com.course.core.exception.TransferException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.TransactionValidateUseCase;

public class TransactionValidadeUseCaseImpl implements TransactionValidateUseCase {
    private TransactionValidadeGateway transactionValidadeGateway;

    public TransactionValidadeUseCaseImpl(TransactionValidadeGateway transactionValidadeGateway) {
        this.transactionValidadeGateway = transactionValidadeGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {

        if (!transactionValidadeGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
