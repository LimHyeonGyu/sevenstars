package deu.ex.sevenstars.exception;

public enum ProductException {
    NOT_FOUND("Product NOT FOUND", 404),
    NOT_REGISTERED("Product NOT Registered", 400),
    NOT_MODIFIED("Product NOT Modified", 400),
    NOT_REMOVED("Product NOT Removed", 400),
    NOT_MATCHED("Product NOT Matched", 400);

    private ProductTaskException productTaskException;

    ProductException(String message, int code) {
        productTaskException = new ProductTaskException(message, code);
    }

    public ProductTaskException get() {
        return productTaskException;
    }
}
