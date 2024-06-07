package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.CreateTransactionGateway;
import br.com.course.core.domain.Transaction;
import br.com.course.core.exception.TransferException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        Transaction transactionSaved = createTransactionGateway.create(transaction);

        if (transaction == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
