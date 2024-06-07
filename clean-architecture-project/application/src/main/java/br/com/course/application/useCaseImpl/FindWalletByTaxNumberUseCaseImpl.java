package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.FindWalletByTaxNumberGateway;
import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.NotFoundException;
import br.com.course.core.exception.enums.ErrorCodeEnum;
import br.com.course.useCase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        Wallet wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet;
    }
}
