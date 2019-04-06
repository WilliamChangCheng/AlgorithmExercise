package leetcode.array;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 *
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 *
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
    /**
     * 到达当前台阶时判断下从前一个台阶过来省事，还是从前一个的前一个过来省事，一直累加到最后一个台阶完，最小值就是最省体力的。
     * 下面方法中，正序遍历倒序遍历都一样
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int f2 = 0, f1 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f2, f1);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f2, f1);
    }
}
