package app.northwind.core.utilities.result;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean isSuccess) {
        success = isSuccess;
    }

    public Result(boolean isSuccess, String message) {
        this(isSuccess);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
