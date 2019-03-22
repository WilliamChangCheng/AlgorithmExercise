package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */

public class ShortestSubarray_withSum_atLeastK {

    public int shortestSubarray(int[] A, int K) {
        int[] sumA = new int[A.length + 1];
        //要求的是最短长度，所以需要res大于A的长度
        int res = A.length + 1;
        //用来存储A元素和的指针
        Deque<Integer> sumAIndex = new ArrayDeque<>();
        //将A的元素累加起来
        for (int i = 0;i < A.length; i++) sumA[i + 1] = sumA[i] + A[i];
        for (int i = 0; i < sumA.length; i++) {
            //sumA[j] - sumA[i]就是A[i]到A[j-1]的和,若大于k说明此子序列满足，比较拿出最短的
            while (sumAIndex.size() > 0 && sumA[i] - sumA[sumAIndex.getFirst()] >= K)
                res = Math.min(res, sumA[sumAIndex.pollFirst()]);
            //清除一些不够大于k的指针，且是遇见负数，使和变小，影响遇到合适的数的循环
            while (sumAIndex.size() > 0 && sumA[i] <= sumA[sumAIndex.getLast()] )
                sumAIndex.pollLast();
            sumAIndex.addLast(i);
        }
        return res <= A.length ? res : -1;
    }
}
