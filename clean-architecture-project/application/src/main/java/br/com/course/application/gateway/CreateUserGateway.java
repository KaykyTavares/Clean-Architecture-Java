package br.com.course.application.gateway;

import br.com.course.core.domain.TransactionPin;
import br.com.course.core.domain.User;
import br.com.course.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);
}
