package br.com.course.useCase;

import br.com.course.core.domain.User;
import br.com.course.core.exception.EmailException;
import br.com.course.core.exception.InternalServerErrorException;
import br.com.course.core.exception.TaxNumberException;
import br.com.course.core.exception.TransectionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransectionPinException, InternalServerErrorException;
}
