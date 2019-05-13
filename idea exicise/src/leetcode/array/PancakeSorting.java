package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A, we can perform a pancake flip:
 * We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.
 * We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
 * Return the k-values corresponding to a sequence of pancake flips that sort A.
 * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 *
 * Example 1:
 * Input: [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k=4): A = [1, 4, 2, 3]
 * After 2nd flip (k=2): A = [4, 1, 2, 3]
 * After 3rd flip (k=4): A = [3, 2, 1, 4]
 * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
 *
 * Example 2:
 * Input: [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 100
 * A[i] is a permutation of [1, 2, ..., A.length]
 *
 * 分析
 * i位置不是i+1，就在0到i - 1中找到i + 1这个数，然后把他翻转到0位置，然后在翻转到i位置，以此类推，每两次翻转都能确定一个最大的在最终位置
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int len = A.length;
        for (int i = len - 1; i >= 0; i--) {
            //小组中最数的位置不在最终位置
            if (A[i] != i + 1) {
                for (int j = 0; j < i; j++) {
                    if (A[j] == i + 1) {
                        //把数反转到0位置，再反回i位置
                        res.add(j + 1);
                        reverse(A, 0, j);
                        res.add(i + 1);
                        reverse(A, 0, i);
                    }

                }
            }
        }
        return res;
    }

    public void reverse(int[] a, int start, int end) {
        int j = end;
        for (int i = start; i < (end - start + 1) / 2; i++) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
        }
    }
    //官方解答
    public List<Integer> pancakeSort1(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
}
