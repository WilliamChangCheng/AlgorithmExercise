package leetcode.array;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Note:
 * 0 ≤ N ≤ 30.
 */
public class FibonacciNumber {
    //时间复杂度O(N), 空间复杂度O(N)
    int fib(int N) {
        if (N <= 1) return N;
        int[] num = new int[N + 1];
        num[1] = 1;
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[N];
    }

    //时间复杂度O(N), 空间复杂度O(1)
    int fib1(int N) {
        if (N <= 1) return N;
        int a = 0, b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    //根据题意也可以这样做
    //全局变量存储所有的斐波那契数
    int[] fibo = new int[31];
    int fib2(int N) {
        if (N <= 1) return N;
        if (fibo[N] == 0) return fibo[N] = fib2(N - 1) + fib2(N - 2);
        else return fibo[N];
    }
}
