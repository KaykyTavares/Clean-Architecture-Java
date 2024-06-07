package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.ConsultBalanceGateway;
import br.com.course.core.domain.Wallet;
import br.com.course.useCase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
