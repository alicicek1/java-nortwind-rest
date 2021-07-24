package app.northwind.core.extension;

public class CommonExtension {

    public static boolean IsNull(Object value) {
        return value == null;
    }

    public static boolean IsNotNull(Object value) {
        return value != null;
    }
}
