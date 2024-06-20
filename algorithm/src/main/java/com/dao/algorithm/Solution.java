package com.dao.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-17
 **/
public class Solution {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        int index = 1;
        for (List<Integer> q : queries) {
            int left = q.get(0), right = q.get(1), summand = q.get(2);
            arr[--left] += summand; // 0-based
            if (right < n) {
                arr[right] -= summand;
            }
            System.out.println("第" + index + "次计算之后： ");
            Arrays.stream(arr).forEach(item -> System.out.print(item + ","));
            System.out.println();
            index++;
        }
        Arrays.parallelPrefix(arr, Math::addExact);
        return Arrays.stream(arr).max().getAsLong();
    }

    public static long arrayManipulation1(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        for (int i = 0; i < queries.size(); i++) {
            int left = queries.get(i).get(0);
            int right = queries.get(i).get(1);
            int summand = queries.get(i).get(2);
            arr[--left] += summand;
            if (right < n) {
                arr[right] -= summand;
            }
        }
        Arrays.parallelPrefix(arr, Math::addExact);
        return Arrays.stream(arr).max().getAsLong();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}