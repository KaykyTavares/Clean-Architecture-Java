package br.com.course.application.useCaseImpl;

import br.com.course.application.gateway.UserNotificationGateway;
import br.com.course.core.domain.Transaction;
import br.com.course.useCase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {
    private UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
