package app.northwind.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult() {
        super(false);
    }

    public ErrorDataResult(String message, T data) {
        super(false, message, data);
    }

    public ErrorDataResult(T data) {
        super(false, "Model is null", data);
    }


}
