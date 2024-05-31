package br.com.course.useCase;

import br.com.course.core.domain.Transection;

public interface TransactionValidateUseCase {
    Boolean validate(Transection transection);
}
