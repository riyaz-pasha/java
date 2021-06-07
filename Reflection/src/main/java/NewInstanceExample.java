import java.lang.reflect.InvocationTargetException;

class Test {
    public void message() {
        System.out.println("Hello");
    }
}

public class NewInstanceExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("Test");
        Test test = null;
        try {
            test = (Test) c.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        test.message();
    }
}
