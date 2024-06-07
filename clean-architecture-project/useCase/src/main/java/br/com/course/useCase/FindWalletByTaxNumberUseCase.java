package br.com.course.useCase;

import br.com.course.core.domain.Wallet;
import br.com.course.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws NotFoundException;
}
