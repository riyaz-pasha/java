class Simple {
}

public class ForNameExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("Simple"); // It just return instance of class not the instance of simple.. so You cannot access methods of Simple
        System.out.println(c.getName());
    }
}
