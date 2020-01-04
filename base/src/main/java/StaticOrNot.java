import java.util.ArrayList;
import java.util.List;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-18 16:07
 **/
public class StaticOrNot {

    public static void greeting() {
        System.out.println("Hello, nice to meet you!");
    }

    public static void main(String[] args) {
//        staticFunction(b);
//
//        List<Integer> list = new ArrayList();
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        StaticOrNot staticOrNot = null;
        staticOrNot.greeting();
    }

    public StaticOrNot() {
        System.out.println("I am in a constructor");
    }

    static StaticOrNot me = new StaticOrNot();

    static {
        System.out.println("I am a static statement");
    }

    // 为什么会是这一个语句最先执行呢？？

    {
        System.out.println("I am either a static statement, or in main function");
    }

    public static void staticFunction(int a) {
        System.out.println("I am a static function");
    }

    int a = 123;
    static int b = 456;
}