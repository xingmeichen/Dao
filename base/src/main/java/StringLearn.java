/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-11-18 18:48
 **/
public class StringLearn {

    /**
     * 1、== 的结果是true,表示地址相同，也就是指向的是同一个对象
     * */
    public static void equalOrNot() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "" + s2;
        String s4 = s2;
        String s5 = "a" + "b" + "c";
        String s6 = new String("abc");
        String s7 = new String(s1);
        final String s8 = "bc";
        String s9 = "a" + s8;
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false 容易犯错
        System.out.println(s1 == s4); // true
        System.out.println(s1 == s5); // true
        System.out.println(s1 == s6); // false
        System.out.println(s1 == s7); // false
        System.out.println(s1 == s9); // true 容易犯错
    }

    /**
     * 该方法的调用不会对方法外的实参造成任何影响，因为当调用这个方法的时候，
     * 只是将实际参数的值赋值给了形参a, b，然后在方法对a, b进行交换
     */
    public static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println("before swap: a = " + a + ", b = " + b);
        swap(a, b);
        System.out.println("after swap: a = " + a + ", b = " + b);
    }
}