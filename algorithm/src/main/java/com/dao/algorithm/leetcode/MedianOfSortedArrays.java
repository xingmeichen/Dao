package com.dao.algorithm.leetcode;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2019-10-20 11:57
 **/
public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] nums = new int[nums1.length+nums2.length];
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                nums[i+j] = nums2[j];
                j++;
                continue;
            } else if (j == nums2.length) {
                nums[i+j] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                nums[i+j] = nums1[i];
                i++;
            } else {
                nums[i+j] = nums2[j];
                j++;
            }
        }
        if ((i + j) % 2 == 0) {
            return (nums[(nums.length-1) / 2] + nums[(nums.length-1) / 2 + 1] )/ 2.0;
        } else {
            return nums[nums.length / 2] / 1.0;
        }
    }

    public static void main(String[] args) {
        MedianOfSortedArrays impl = new MedianOfSortedArrays();
        double result = impl.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 4, 5, 6});
        System.out.println(result);
    }
}