package com.projetocoach.exception;

public class VeiculoException extends RuntimeException {

    public VeiculoException() {
    }

    public VeiculoException(String msg) {
        super(msg);
    }

    public VeiculoException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
