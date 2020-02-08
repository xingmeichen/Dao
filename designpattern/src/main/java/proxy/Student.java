package proxy;

/**
 * @author Mabel
 */
public class Student implements Person {

    @Override
    public void task() {
        System.out.println("Learn");
    }

    public static void main(String[] args) {
        System.out.println("Hell, I am Student");
    }
}
