package leetcode.array;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 *Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Example 1:
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * Example 2:
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 *
 * Example 3:
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * Note:
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000\
 *
 * 分析
 * 能分成三份，说明一定能被3整除
 * 能被3整除后，就再证明是否可以分成3份；
 * 凑成整数除以3后，份数加1;
 * 循环完后，看份数是不是3份
 */

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        boolean res = false;
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        //总数整除3
        if (sum % 3 == 0) {
            int num = sum / 3;
            int partCount = 0;
            int tempSum = 0;
            for (int a : A) {
                tempSum += a;
                if (tempSum == num) {
                    tempSum = 0;
                    partCount++;
                }
            }
            return partCount == 3;
        } else {
            return false;
        }

    }
}
