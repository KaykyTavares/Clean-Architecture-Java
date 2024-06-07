package br.com.course.application.gateway;

import br.com.course.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
