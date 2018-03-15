package com.embraces.hive.mvc;

public class EsRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -7936621829410590188L;

    public EsRuntimeException() {
        super();
    }

    public EsRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EsRuntimeException(String message) {
        super(message);
    }

    public EsRuntimeException(Throwable cause) {
        super(cause);
    }

}
