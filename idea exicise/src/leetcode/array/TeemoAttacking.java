package leetcode.array;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 * 示例1:
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 在第 1 秒开始时，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒钟结束。
 * 在第 4 秒开始时，提莫再次攻击艾希，使得艾希获得另外 2 秒的中毒时间。
 * 所以最终输出 4 秒。
 *
 * 示例2:
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 在第 1 秒开始时，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒钟结束。
 * 但是在第 2 秒开始时，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒开始时的这次攻击会在第 3 秒钟结束。
 * 所以最终输出 3。
 *
 * 注意：
 * 你可以假定时间序列数组的总长度不超过 10000。
 * 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。
 *
 * 分析
 * 1. 可以根据前一个判断有多少时间过去了，要加多少
 * 2. 可以简化成，上一个攻击的理想end是time加duration, 到了下一个，
 *    如果大于等于理想时间，就算出duration减去（end-现在的时间点time），就算出了这一个时间到上一个时间的差，加上就是
 *    如果现在的时间点大于end，就直接加上duration，省去了处理最后一个时间点的代码
 *
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int sum = 0;
        int fomer = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            int timeSery = timeSeries[i];
            int substract = timeSery - fomer;
            if (substract >= duration) {
                sum += duration;
            } else {
                sum += substract;
            }
            fomer = timeSery;
        }
        if (timeSeries.length >= 1) sum += duration;
        return sum;
    }

    /**
     * 优化方法
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int res = 0, end = -1;
        for (int timeSery : timeSeries) {
            if (timeSery >= end) {
                res += duration;
            } else {
                res += duration - (end - timeSery);
            }
            end = timeSery + duration;
        }
        return res;
    }

}
