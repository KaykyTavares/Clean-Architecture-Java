package br.com.course.application.gateway;

import br.com.course.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
