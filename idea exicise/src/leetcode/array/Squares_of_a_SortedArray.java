package leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 题目
 * Given an leetcode.array of integers A sorted in non-decreasing order, return an leetcode.array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * <p>
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class Squares_of_a_SortedArray {
    //自己想的负数缓存法，速度太慢
    public static int[] sortedSquares(int[] A) {
        ArrayList<Integer> squares = new ArrayList<Integer>();
//        int[] squares = new int[A.length];
        //缓存负数，最多不过A的长度
        Deque<Integer> negative = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            //负数
            if (A[i] < 0) {
                negative.add(-A[i]);
            } else {
                while (!negative.isEmpty() && negative.getLast() < A[i]) {
                    int num = negative.pollLast();
                    squares.add(num * num);
                }
                squares.add(A[i] * A[i]);
            }
        }
        //把剩下的负数加上
        int size = negative.size();
        for (int i = 0; i < size; i++) {
            int num = negative.pollLast();
            squares.add(num * num);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = squares.get(i);
//            squares.indexOf()
        }
        return res;
    }

    /**
     * 双指针法
     * @param A
     * @return
     */
    public static int[] sortedSquares1(int[] A) {
        int len = A.length;
        //存储平方和
        int[] squ = new int[len];
        //两个指针，一个在头部分，一个在尾
        int i = 0, j = len - 1;
        //循环主题为平方和数组,从后往前存，绝对值最大的一定在A数组的两端
        for (int k = len - 1; k >= 0; k--) {
            if(Math.abs(A[i]) > Math.abs(A[j])) {
                squ[k] = A[i] * A[i];
                i++;
            } else {
                squ[k] = A[j] * A[j];
                j--;
            }
        }
        return squ;
    }

    public static void main(String[] args) {
        int[] a = sortedSquares1(new int[]{-5, -2, 0,1,4});
    }
}
