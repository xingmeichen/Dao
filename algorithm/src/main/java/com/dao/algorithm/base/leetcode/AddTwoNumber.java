package com.dao.algorithm.base.leetcode;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-10-19 12:37
 **/

import java.util.Random;

public class AddTwoNumber {

    public ListNode addTwoNumbersV(ListNode l1, ListNode l2) {
        int multiple1 = 1, multiple2 = 1;
        int total = 0;
        while (null != l1 || null != l2) {
            if (null != l1) {
                total += l1.val * multiple1;
                l1 = l1.next;
                multiple1 *= 10;
            }
            if (null != l2) {
                total += l2.val * multiple2;
                l2 = l2.next;
                multiple2 *= 10;
            }
        }
        ListNode result = new ListNode(0);
        while (total / 10 != 0) {
            ListNode parent = result;
            ListNode sub = parent.next;
            while (null != sub) {
                parent = sub;
                sub = sub.next;
            }
            parent.val = total % 10;
            parent.next = new ListNode(0);
            total = total / 10;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cusor = result;
        int sum = 0;
        while (null != l1 || null != l2) {
            if (null != l1) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                sum += l2.val;
                l2 = l2.next;
            }
            cusor.next = new ListNode(sum % 10);
            cusor = cusor.next;
            sum /= 10;
        }
        if (0 < sum) {
            cusor.next = new ListNode(sum);
        }
        return result.next;
    }

    private ListNode gen(int i) {
        int next = 0;
        Random random = new Random();
        ListNode l = null;
        try {
            int nextInt = random.nextInt(8) + 1;
            l = new ListNode(nextInt);
            ListNode p = l;
            ListNode s = p.next;
            while (next < i) {
                while(s != null) {
                    p = s;
                    s = s.next;
                }
                nextInt = random.nextInt(8) + 1;
                s = new ListNode(nextInt);
                p.next = s;
                next++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    private void print(ListNode l) {
        System.out.print("[");
        while (null != l) {
            System.out.print(l.val);
            l = l.next;
            if (l != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode l1 = addTwoNumber.gen(7);
        ListNode l2 = addTwoNumber.gen(3);
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);
        System.out.println();
        addTwoNumber.print(l1);
        System.out.println();
        addTwoNumber.print(l2);
        System.out.println();
        addTwoNumber.print(result);
        System.out.println();
    }
}