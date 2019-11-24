package base;

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
    public static void main(String[] args) {
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
}