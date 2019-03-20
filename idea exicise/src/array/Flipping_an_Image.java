package array;

/**
 * 题目
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */

public class Flipping_an_Image {
    public static int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        int first = 0, last = 0;
        for (int i = 0; i < len; i++) {
            first = 0;
            last = A[i].length - 1;
            while (first < last) {
                //翻转且倒置；两者都和01异或，则01变成了00，00变成了01
                int temp = A[i][first] ^= 1;
                A[i][first] = A[i][last] ^= 1;
                A[i][last] = temp;
                //
                first++;
                last--;
            }
            //个数是奇数个的时候，中间一个会不处理
            if (first == last) A[i][first] ^= 1;
        }
        return A;
    }
    public static void main(String[] args) {
        int[][] a = flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}});
    }
}
