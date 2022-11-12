package com.dao.hw;

import java.util.Scanner;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-05-31 00:03
 **/
public class Encryption {

    public static int[] password(int n) {
        int[] result = new int[n];
        int index = 0;
        while (index < n) {
            if (0 == index) {
                result[index] = 1;
            } else if (1 == index){
                result[index] = 2;
            } else if (2 == index) {
                result[index] = 4;
            } else {
                result[index] = result[index-1] + result[index-2] + result[index-3];
            }
            index++;
        }
        return result;
    }

    public static void encrypt(char[] str, int[] encryptStr) {
        int index = 0;
        int length = str.length;
        while (index < length) {
            str[index] = (char) (97 + ((int)str[index] - 97 + encryptStr[index]) % 26 );
            System.out.print(str[index] + " ");
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int index = 0;
        char[] str = new char[n];
        while(index < n) {
            str[index] = scanner.next().charAt(0);
            index++;
        }
        password(n);
        encrypt(str, password(n));
    }
}