package app.northwind.core.utilities.result;

import java.util.List;

public class DataResult<T> extends Result {

    private T data;
    private List<T> datas;

    public DataResult(boolean isSuccess) {
        super(isSuccess);
    }

    public DataResult(boolean isSuccess, String message, T data) {
        super(isSuccess, message);
        this.data = data;
    }

    public DataResult(boolean isSuccess, String message, List<T> datas) {
        super(isSuccess, message);
        this.datas = datas;
    }

    public DataResult(boolean isSuccess, T data) {
        super(isSuccess);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
