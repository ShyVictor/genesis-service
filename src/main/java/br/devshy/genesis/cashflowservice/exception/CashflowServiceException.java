package br.devshy.genesis.cashflowservice.exception;

public class CashflowServiceException extends RuntimeException {
    public CashflowServiceException() {}

    public CashflowServiceException(String message) {
        super(message);
    }

    public CashflowServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashflowServiceException(Throwable cause) {
        super(cause);
    }
}

