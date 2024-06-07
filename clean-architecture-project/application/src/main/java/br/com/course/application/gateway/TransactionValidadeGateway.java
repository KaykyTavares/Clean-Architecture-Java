package br.com.course.application.gateway;

import br.com.course.core.domain.Transaction;
import br.com.course.core.exception.TransferException;

public interface TransactionValidadeGateway {
    Boolean validate(Transaction transaction);
}
