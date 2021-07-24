package app.northwind.core.utilities.result;

import java.util.List;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult() {
        super(true);
    }

    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }

    public SuccessDataResult(T data) {
        super(true, data);
    }

    public SuccessDataResult(String message) {
        super(true, message, (List<T>) null);
    }
}
