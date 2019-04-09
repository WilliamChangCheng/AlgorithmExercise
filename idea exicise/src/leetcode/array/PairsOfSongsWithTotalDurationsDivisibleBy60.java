package leetcode.array;

/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * Note:
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    //要找的数x满足要求(t + x) % 60 = 0；推导公式，t % 60 + x % 60 = 60就满足要求，60 - t % 60 = x % 60;考虑到t % 60 = 0, x % 60 = 0
    //60 - t % 60 的余数范围 1到60.而t % 60的余数范围0到59，无法吻合，（60 - t % 60）% 60，也能满足t % 60 = 0, x % 60 = 0的情况;
    public int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(60 - t % 60) % 60];
            //加1的原因：数组[30,90,150]，走到30时，c[30] = 1，res为0；90时，c[30]为2，说明，余数为30的有两个数了，res为1；
            // 150时，余数为30，c[30]为2，就是说，150可以与两个数组合，res为3
            c[t % 60] += 1;
        }
        return res;

    }


}
