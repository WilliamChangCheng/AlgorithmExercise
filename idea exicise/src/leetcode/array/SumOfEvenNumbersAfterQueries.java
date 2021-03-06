package leetcode.array;

/**
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class SumOfEvenNumbersAfterQueries {
    /**
     * 先遍历一遍，算出偶数和来，然后在添加数据之前，判断加上后是否是偶数，若是，加上此查询数，若成为奇数，就减去A中数，最后把查询数加上
     * @param A
     * @param queries
     * @return
     */
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        //求出初始偶数和
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sum += A[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) sum -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) sum += A[index];
            //下边是自己的方法，有点啰嗦
//            int add = queries[i][0] + A[queries[i][1]];
//            if (add % 2 == 0) {
//                if (A[queries[i][1]] % 2 ==0) sum += queries[i][0];
//                else sum += add;
//            } else if (A[queries[i][1]] % 2 ==0) sum -= A[queries[i][1]];
//            A[queries[i][1]] = add;
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = sumEvenAfterQueries(new int[] {1,2,3,4}, new int[][] {{1,0},{-3,1},{-4,0},{2,3}});
    }
}
