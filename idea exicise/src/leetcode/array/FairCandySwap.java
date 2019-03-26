package leetcode.array;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 * Example 1:
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 *
 * Example 3:
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 *
 * Example 4:
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 *
 * Note:
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * It is guaranteed that Alice and Bob have different total amounts of candy.
 * It is guaranteed there exists an answer.
 *
 * 分析：
 * If Alice swaps candy x, she expects some specific quantity of candy y back.
 * A总数为Sa,B的总数为Sb
 * A给b x个糖果，收到y个，b给a y个糖果，收到x个，公式如下
 * sa - x + y = sb - y + x；
 * （sa - sb）/ 2 + y = x；
 * 令 （sa - sb）/ 2 等于 dif
 * 把a放进hashset中
 * 利用公式，循环b，从dif + b，从a中查找是否是有，有则输出a的糖果罐是dif + b，b的是当前循环的b值
 * 也可以公式反过来，求（sb- sa）/2 + x = y；就变成了把b放进hashset集合中，循环a，查看set集合是否有a加（sb- sa）/2，有则输出，a的糖罐为当前值，b的糖罐为当前值加（sb- sa）/2
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0;
        int bSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            aSum += A[i];
            set.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            bSum += A[i];
        }
        int dif = (aSum - bSum) / 2;
        for (int b : B) {
            if (set.contains(b + dif))
                return new int[] {dif + b, b};
        }
        throw null;
    }
}
