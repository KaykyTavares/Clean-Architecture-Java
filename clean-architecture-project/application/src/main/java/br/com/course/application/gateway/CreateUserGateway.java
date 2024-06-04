package br.com.course.application.gateway;

import br.com.course.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
