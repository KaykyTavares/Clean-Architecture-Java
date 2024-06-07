package br.com.course.useCase;

import br.com.course.core.domain.Transaction;
import br.com.course.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
