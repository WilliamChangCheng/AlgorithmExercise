package queue;

import java.util.TreeSet;

/**
 * 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 * <p>
 * 示例:
 * <p>
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 说明：
 * <p>
 * 矩阵内的矩形区域面积必须大于 0。
 * 如果行数远大于列数，你将如何解答呢？
 */


public class MaxSumOfRectangleNoLargerThanK {

    public static int[] celling(int[] num, int len, int k) {
        int preRes = 0;
        int res = Integer.MIN_VALUE;
        //记录大于等于k且最小的元素位置
        int first = -1;
        for (int i = 0; i < len; i++) {
            if (num[i] >= k) {
                preRes = res;
                res = num[i];
                int tempIndex = first;
                first = i;
                if (res > k && res > preRes) {
                    res = preRes;
                    first = tempIndex;
                }
            }
        }
        return new int[]{res, first};
    }
//region 数组最大子序列和

    /**
     * 求一维数组最大子序列和
     *
     * @param num
     * @return
     */
    public static int[] maxSumSeq(int[] num) {
        //0：表示最大值，1：序列开始位置，2：序列结束位置
        int max = 0, up = 0, down = 0;
        int maxArray = Integer.MIN_VALUE;
        int finalUp = 0, finalDown = 0;
        for (int i = 0; i < num.length; i++) {
            //num[i] > max + num[i]就代表遇见了一个让前方的和为负的情况，意思是前面的数据不能要了，比如{2, 2, -5, 5}，走到了num[3]
            if (num[i] > max + num[i]) {
                up = down = i;
                max = num[i];
            } else {
                down = i;
                max = max + num[i];
            }
            if (max > maxArray) {
                maxArray = max;
                finalUp = up;
                finalDown = down;
            }
        }
        //0：表示最大值，1：开始位置，2：结束位置
        return new int[]{maxArray, finalUp, finalDown};
    }

    /**
     * 求二维数组最大子序列和
     * 先降维，再求一位数组的最大子序列和
     *
     * @param matrix
     * @return
     */
    public static int[] maxSumMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        //子序列左列指针
        int maxLeft = 0;
        //子序列右列指针
        int maxRight = 0;
        //子序列行上指针
        int maxUp = 0;
        //子序列行下指针
        int maxDown = 0;
        //左边的列
        for (int l = 0; l < matrix[0].length; l++) {
            //存储累加的列
            int[] vec = new int[matrix[0].length];
            //右边的列
            for (int r = l; r < matrix[0].length; r++) {
                //r列累加到vec中
                for (int i = 0; i < matrix.length; i++) {
                    //i行，r列
                    vec[i] += matrix[i][r];
                }
                //求一位数组的最大子序列的和
                int[] curArray = maxSumSeq(vec);
                if (curArray[0] > maxSum) {
                    maxSum = curArray[0];
                    maxLeft = l;
                    maxRight = r;
                    maxUp = curArray[1];
                    maxDown = curArray[2];
                }


            }
        }
        return new int[]{maxSum, maxLeft, maxRight, maxUp, maxDown};
    }
//endregion

//region 数组不超过k的最大子序列和

    /**
     * 求一维数组不超过k的最大子序列和
     * 如果要求子序列位置，可以吧TreeSet换成TreeMap
     * 为什么要用排序，就是为了好找，不用排序也能找到
     *
     * @param num
     * @param k
     * @return
     */
    public static int maxSumNoThanK(int[] num, int k) {
        //如果要求子序列位置，可以吧TreeSet换成TreeMap
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int cum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            cum += num[i];
            Integer cur = ts.ceiling(cum - k);
            if (cur != null) res = Math.max(res, cum - cur);
            ts.add(cum);
        }
        return res;
    }

    /**
     * 求二维数组的不超过k的最大子序列和
     * 如果要求子序列位置，可以吧TreeSet换成TreeMap
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int maxSumMatrix(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        //左边的列
        for (int l = 0; l < matrix[0].length; l++) {
            //存储累加的列
            int[] vec = new int[matrix.length];
            //右边的列
            for (int r = l; r < matrix[0].length; r++) {
                //r列累加到vec中
                for (int i = 0; i < matrix.length; i++) {
                    //i行，r列
                    vec[i] += matrix[i][r];
                }
                maxSum = Math.max(maxSum, maxSumNoThanK(vec, k));
            }
        }
        return maxSum;
    }
//endregion


    public static void main(String[] args) throws NullPointerException {
//        int[] a = maxSumMatrix(new int[][] {{2,1,-3,-4,5},{0,6,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}});
//        int[] b = new int[] {1,1};
        int c = maxSumMatrix(new int[][]{{2, 2, -1}}, 0);
//        int d = maxSumMatrix(new int[][] {{7,7,4,-6,-10},{-7,-3,-9,-1,-7},{9,6,-3,-7,7},{-4,1,4,-3,-8},{-7,-4,-4,6,-10},{1,3,-2,3,-10},{8,-2,1,1,-8}}, 12);
    }

}
