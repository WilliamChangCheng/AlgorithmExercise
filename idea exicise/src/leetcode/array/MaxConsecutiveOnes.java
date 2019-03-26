package leetcode.array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *              The maximum number of consecutive 1s is 3.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, sum = 0;
        for (int a : nums) {
            if (a == 1) {
                sum++;
            } else {
                res = res > sum ? res : sum;
                sum = 0;
            }
        }
        res = res > sum ? res : sum;
        return res;
    }
    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0, sum = 0;
        for (int a : nums) {
            res = Math.max(res, sum = a == 0 ? 0 : sum + 1);
        }
        return res;
    }
}
