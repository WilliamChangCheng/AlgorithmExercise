package leetcode.array;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 * Note：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int jinwei = 0;
        int i = A.length - 1;
        while (K != 0 || i >= 0) {
            int k = K % 10;
            int a = 0;
            if (i >= 0) a = A[i];
            i--;
            res.add((a + k + jinwei) % 10);
            jinwei = (a + k + jinwei) / 10;
            K = (K - k) / 10;
        }
        if (jinwei != 0) res.add(jinwei);
        //反转数组
        int half = res.size() / 2;
        int m = res.size() - 1;
        for (int j = 0; j < half; j++) {
            int temp = res.get(m);
            res.set(m, res.get(j));
            res.set(j, temp);
            m--;
        }
        return res;
    }

    /**
     * 因为K是int型，可以吧两个数加在K上，就不用进位变量了
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int i = A.length;
        int cur = K;
        List<Integer> res = new ArrayList<>();
        while (--i > 0 || cur > 0){
            if (i >= 0) cur += A[i];
            res.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = addToArrayForm(new int[] {2,1,5},806);

    }
}
