package leetcode.array;

/**
 * 最大子序列和
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max + num) {
                max = num;
            } else {
                max += num;
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
