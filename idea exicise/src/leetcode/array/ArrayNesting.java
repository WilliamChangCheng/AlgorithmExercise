package leetcode.array;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1.
 * Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * Suppose the first element in S starts with the selection of element A[i] of index = i,
 * the next element in S should be A[A[i]], and then A[A[A[i]]]…
 * By that analogy, we stop adding right before a duplicate element occurs in S.
 *
 * Example 1:
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class ArrayNesting {
    /**
     * nums数组遍历，若果i所在标识为ture，就跳过，i++
     * 若i所在位置未被访问过，就进入while循环
     * 用一个布尔数组标识是否访问过，若访问过就代表，走到头了，否则接着继续访问，count++；
     * 空间复杂度为O(n),时间为O（n）
     *
     * 也可以不用新建一个标识数组，在nums数组中标志为-1，如果为-1，就代表来过，空间复杂度为O(1)
     * @param nums
     * @return
     */
    public static int arrayNesting(int[] nums) {
        int max = 0;
        //题目要求，所有数都不相同，即不会有两个数同时指向同一位置，若指向就代表
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            int count = 0;
            int temp = nums[i];
            while (!flag[temp]) {
                flag[temp] = true;
                temp = nums[temp];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
