package proxy;

/**
 * @author Mabel
 */
public class Teacher implements Person {

    @Override
    public void task() {
        System.out.println("Teach");
    }

    public static void main(String[] args) {
        System.out.println("Hello, I am Teacher");
    }
}
