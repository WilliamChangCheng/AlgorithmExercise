package leetcode.array;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {
    //原想用hashMap做，两边循环。答案也是两遍循环，空间复杂度是常量更好

    /**
     * 可以用hashmap，空间复杂度为O(N)，就是用总数，减去当前的位置之前的总数，如果与前一个位置的总数相等，此位置就是要找的位置。
     * 也可以用两个常量完成，一个计算出总数，然后，一个位置一个个的遍历，当总数减去前一个位置的总和与当前位置的数，如果和前一个位置的总和相等，就找到了
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
