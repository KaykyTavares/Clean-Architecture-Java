package br.com.course.useCase;

import br.com.course.core.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction);
}
