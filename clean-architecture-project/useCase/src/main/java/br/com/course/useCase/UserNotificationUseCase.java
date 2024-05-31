package br.com.course.useCase;

import br.com.course.core.domain.Transection;

public interface UserNotificationUseCase {
    Boolean notificate(Transection transection, String email);
}
