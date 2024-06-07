package br.com.course.application.gateway;

import br.com.course.core.domain.Transaction;

public interface TransferGateway {
    Boolean tranfer(Transaction transaction);
}
