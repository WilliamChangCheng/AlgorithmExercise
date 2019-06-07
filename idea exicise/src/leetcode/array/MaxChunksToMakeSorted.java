package leetcode.array;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.  After concatenating them,
 * the result equals the sorted array.
 * What is the most number of chunks we could have made?
 *
 * Example 1:
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 *
 * Example 2:
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 *
 * Note:
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class MaxChunksToMakeSorted {
    /**
     * 自己想的
     * 思路
     * 有个标志为end，代表上一组的结束位置，
     * 如果现在这个位置在end之中，现在位置的元素的实际位置大于end，就更新end位置
     * 如果，现在位置在end位置之后，分组就加一
     * 如果i位置的元素所在的位置就是i，且i所在位置在end之外，分组加1，更新end为i；
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        int end = -1;
        int chunk = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= i) {
                //保证i位置在end之外，防止像[4,3,2,1,0]的情况出现
                if (arr[i] == i && arr[i] > end) {
                    chunk++;
                    end = i;
                } else {
                    //i超过了end位置，代表可以分一个新组了
                    if (i > end) chunk++;
                    end = Math.max(end, arr[i]);
                }
            }
        }
        return chunk;
    }

    /**
     * 官方解答
     * 标记且更新end位置，如果i到了更新后end位置，说明可以分组可以加1了
     * @param arr
     * @return
     */
    public int maxChunksToSorted1(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            //走到end位置，就代表这组可以加了
            if (max == i) ans++;
        }
        return ans;
    }
}
