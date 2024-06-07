package br.com.course.core.exception;

public class NotificationException extends Exception {
    private String code;

    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
