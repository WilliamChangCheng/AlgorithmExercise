package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * 并且由于要求发现大多数超过[n / 3]的上限，答案将小于或等于两个数字满足要求。
 * 投票法找出出现次数大于一半的数，候选数只用一个就可以，n/3向下取整，就代表需要两个候选数，来遍历
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        //先用投票法找出疑是答案的候选数
        for (int n : nums) {
            if (n == candidate1) {
                count1 += 1;
            } else if (n == candidate2) {
                count2 += 1;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        //验证候选数是不是答案
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == candidate1) count1 += 1;
            if (n == candidate2) count2 += 1;
        }
        if (count1 > nums.length / 3) res.add(candidate1);
        if (count2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}
