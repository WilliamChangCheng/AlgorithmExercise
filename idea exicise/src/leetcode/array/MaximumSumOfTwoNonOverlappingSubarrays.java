package leetcode.array;

/**
 * Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays,
 * which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)
 * Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) and either:
 *
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, or
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 *
 * Example 1:
 * Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * Output: 20
 * Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 *
 * Example 2:
 * Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * Output: 29
 * Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
 *
 * Example 3:
 * Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * Output: 31
 * Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.
 *
 * Note:
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 *
 * 想法1：
 * 先找min(l,m)长度的最大子数组，然后然后刨除这个子数组，然后再找max(l,m)长度的子数组
 * 然后合起来，如果这样不行就再先求大再求小然后求最大值,但是还有一个问题，就是如果先求的在中间，两边的长度满足不了下一个长度问题
 * 舍弃
 *
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        int res = A[L + M - 1];//答案初始值以前L + M个数的和
        int Lmax = A[L - 1];
        int Mmax = A[M - 1];
        //从l+m开始，每次加1，一次次的分治，找到最大的
        for (int i = M + L; i < A.length; i++) {
            //A[i - M] - A[i - M - L],先跑出去最后m个，再计算紧接着的L个，相减计算出和
            Lmax = Math.max(Lmax, A[i - M] - A[i - M - L]);
            Mmax = Math.max(Mmax, A[i - L] - A[i - M - L]);
            //嵌套的max是求出，Lmax加上最后的M个，Mmax加上最后的L个，组成一组，找最大
            res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));

        }
        return res;
    }




}
