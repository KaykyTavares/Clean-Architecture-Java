package br.com.course.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String userName, String password);
}
