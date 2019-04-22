package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 * 注意程序要求，k必须大于等于0，否则个数为0
 */
public class K_diffPairsInAnArray {
    /**
     * - `k == 0`情况
     *   此时就是数有多少个数出现超过两次，根据题意，（i, j)与（j, i）是一个数，所以只要大于二就可以
     * - `k != 0`
     *   此时就是查看有没有k加当前数
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs(int[] nums, int k) {
        //题意要求k小于零，自动返回0
        if (nums == null || nums.length == 0 || k < 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //计算重复值
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) count++;
            } else {
                if (map.containsKey(entry.getKey() + k)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = findPairs(new int[]{3, 1, 4, 1, 5}, 2);
    }
}
