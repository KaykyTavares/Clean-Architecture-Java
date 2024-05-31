package br.com.course.core.exception;

public class TransectionPinException extends Throwable {
    private String code;

    public TransectionPinException(String message, String code) {
        super(message);
        this.code = code;
    }
}
