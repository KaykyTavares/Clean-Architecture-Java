package br.com.course.useCase;

import br.com.course.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
