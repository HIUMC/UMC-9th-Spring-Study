package jpabook2.jpashop2.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String needMoreStock, Throwable cause) {
        super(needMoreStock, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
