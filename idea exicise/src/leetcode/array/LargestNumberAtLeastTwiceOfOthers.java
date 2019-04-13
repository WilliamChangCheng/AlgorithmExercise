package leetcode.array;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceOfOthers {
    //一次遍历，找到最大的和第二大的，如果第二大的二倍小于等于第一大的，就说明满足题意，否则就是不满足；
    public int dominantIndex(int[] nums) {
        int fir = Integer.MIN_VALUE, sec = Integer.MIN_VALUE;
        int firInd = -1, secInd = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= fir) {
                sec = fir;
                secInd = firInd;
                fir = num;
                firInd = i;
            } else if (num > sec) {
                sec = num;
                secInd = i;
            }

        }
        return sec * 2 <= fir ? firInd : -1;
    }
}
