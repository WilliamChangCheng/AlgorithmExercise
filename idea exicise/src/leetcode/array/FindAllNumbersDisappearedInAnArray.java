package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 * 分析：
 * 利用没有数，就不会找到此数所表示的数组位置，找到的标记为原来的值的负；
 * 只能标记为负，因为当遍历到此位置时，还要该位置的数值；确保变了负数的不再变为正
 */

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //让已经变了负数的nums[i]值，让其有效，能找到相应的位置
            int val = Math.abs(nums[i]) - 1;
            //让没变负数的值，变为负数，防止变了的负数变成正数
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        //因为没有该值，所以以此为数组位置的数正数，没被改变过
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;

    }
}
