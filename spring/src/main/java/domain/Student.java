package domain;

import lombok.Data;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-10 13:50
 **/
@Data
public class Student extends User {

    /** 学号 */
    private String number;
}