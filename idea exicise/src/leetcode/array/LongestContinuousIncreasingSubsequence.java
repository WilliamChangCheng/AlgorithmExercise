package leetcode.array;

/**
 * 找最长递增子序列
 */
public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {

        int longest = 0;
        int count = 1;
        if (nums == null) return 0;
        int increase = 0;
        if (nums.length > 1) {
            increase = nums[1] - nums[0];
        }else {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp == increase && temp > 0) {
                count++;
            } else {
                increase = nums[i] - nums[i - 1];

                longest = Math.max(longest, count);
                count = 1;

            }
        }
        return Math.max(longest, count);

    }
    public static int findLengthOfLCIS1(int[] nums) {
        int longest = 0;
        int anchor = 0;
        if (nums.length < 2) return nums.length;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i - 1]) anchor = i;
            longest = Math.max(longest, i - anchor + 1);
        }
        return longest;
    }
    public static int findLengthOfLCIS2(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            //i>0是防止i= 0时运行if语句
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int a = findLengthOfLCIS2(new int[] {1});
    }
}
