package leetcode.array;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Example 1:
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Note:
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 *
 * 分析
 * 只要证明`m[i][j] != m[i - 1][j - 1]`, 就可以断定不是菲普利茨矩阵，让`i，j`都从1开始可以节省时间
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                int num = matrix[i][j];
                int ii = i + 1;
                int jj = j + 1;
                while (ii < r && jj < c) {
                    if (num != matrix[ii][jj]) return false;
                    ii++;
                    jj++;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i -1][j - 1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }

}
