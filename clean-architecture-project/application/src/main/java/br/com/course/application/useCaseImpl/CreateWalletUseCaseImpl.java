package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.CreateWalletGateway;
import br.com.course.core.domain.Wallet;
import br.com.course.useCase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {
    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
