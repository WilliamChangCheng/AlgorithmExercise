package array;

import java.util.Arrays;

/**
 * 题目
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    //排序法，a%2的余来排序
    public static int[] sortArrayByParity1(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];
        //简单的写法，定义一个比较器a%2不是0就是1，0在前就排好了
        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));
        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }

    //双指针分奇偶, 一个指针在队头，一个队尾
    public static int[] sortArrayByParity2(int[] A) {
        int first = 0,last = A.length - 1;
        while (first < last) {
            int fmod = A[first] % 2;
            int lmod = A[last] % 2;
            if (fmod > lmod) {
                int temp = A[last];
                A[last] = A[first];
                A[first] = temp;
            }
            if (fmod == 0) first++;
            if (lmod == 1) last--;

        }
        return A;
    }

    //两次循环法，一次取出偶数，一次取出奇数
    public static int[] sortArrayByParity3(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }




        //自己想的双指针，但是不够完美，思路过于复杂
    public static int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int even = 0, odd = 0;
        while (even != len && odd != len ) {
            if (A[even] % 2 != 0) {
                even++;
            } else {
                //判断odd是否是奇数位置
                if(A[odd] % 2 != 0){
                    //even是偶数位置odd是奇数位置
                    //判断谁在前在后
                    if (even > odd) {
                        int temp = A[even];
                        A[even] = A[odd];
                        A[odd] = temp;
                        odd++;
                        even++;
                    } else {
                        //偶数在前，就让偶数前移
                        even = odd + 1;
                    }
                } else {
                    //odd不是奇数位置
                    odd++;
                }
            }

        }
        return A;
    }


    public static void main(String[] args) {
        int[] a = sortArrayByParity(new int[] {1,3,2,4});

    }
}
