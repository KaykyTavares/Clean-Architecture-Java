package br.com.course.useCase;

import br.com.course.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber);
}
