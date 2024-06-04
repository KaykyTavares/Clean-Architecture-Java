package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.CreateTransactionPinGateway;
import br.com.course.core.domain.TransectionPin;
import br.com.course.useCase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway transactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway transactionPinGateway) {
        this.transactionPinGateway = transactionPinGateway;
    }

    @Override
    public void create(TransectionPin transectionPin) {
        transactionPinGateway.create(transectionPin);
    }
}
