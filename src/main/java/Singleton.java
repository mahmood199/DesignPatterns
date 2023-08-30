

public class Singleton {

    private static volatile Singleton instance;
    private String someData;

    private Singleton(String data) {
        someData = data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }


}
