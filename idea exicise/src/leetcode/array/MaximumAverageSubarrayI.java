package leetcode.array;

public class MaximumAverageSubarrayI {
    //要考虑到从零位置就开始算的最大数
    public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int[] sums = new int[nums.length + 1];

        for (int i = 1; i < sums.length; i++) {
            sums[i ] = sums[i - 1] + nums[i - 1];
            if (i >= k) {
                max = Math.max(max, sums[i] - sums[i - k]);
            }
        }
        return (double) max / k;
    }

    public static void main(String[] args) {
        double d = findMaxAverage(new int[]{4}, 1);
    }

}
