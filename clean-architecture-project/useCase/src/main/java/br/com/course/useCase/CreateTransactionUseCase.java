package br.com.course.useCase;

import br.com.course.core.domain.Transaction;
import br.com.course.core.exception.TransferException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransferException;
}
