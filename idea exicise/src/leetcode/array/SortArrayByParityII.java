package leetcode.array;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 * Note:
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {
    //利用前后两个指针
    public static int[] sortArrayByParityII(int[] A) {
        int odd = 1, even = 0;
        while (odd < A.length && even < A.length) {
            //奇数位置不是奇数，偶数位置不是偶数，就交换
            if (A[even] % 2 != 0 && A[odd] % 2 == 0) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
            //奇数位置是奇数
            if (A[odd] % 2 != 0) {
                odd += 2;
            }
            //偶数位置是偶数
            if (A[even] % 2 == 0) {
                even += 2;
            }


        }
        return A;
    }

    //这个方法更快，可能是因为判断少的原因
    public static int[] sortArrayByParityII1(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            //偶数位置是奇数
            if (A[i] % 2 == 1) {
                //找到第一个奇数位置是偶数的
                while (A[j] % 2 == 1) j += 2;
                //调换位置
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = sortArrayByParityII(new int[] {2,3});
    }
}
