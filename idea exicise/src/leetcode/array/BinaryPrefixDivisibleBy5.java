package leetcode.array;
import java.util.ArrayList;
import java.util.List;
/**
 * Given an array A of 0s and 1s, consider N_i:
 * the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 *
 * Example 1:
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 *
 * Example 2:
 * Input: [1,1,1]
 * Output: [false,false,false]
 *
 * Example 3:
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 *
 * Example 4:
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 *
 * Note:
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int a : A) {
            //num << 1，算出来num但是不能加到a上，得单拿出来
//            num = (num << 1 + a) % 5;
            num <<= 1;
            //Use the fact that (ab + c)%d is same as ((a%d)(b%d) + c%d)%d.
            num = (num + a) % 5;
            res.add(num == 0);
        }
        return res;
    }
}
