package br.com.course.useCase;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String userName, String password);
}
