package dataStructure.analysis_of_Algorithms;

//最大子序列和实现,只能处理带正数的数组
public class MaximumSubsequence {
    public static int maxSubSum(int[] a) {
        int maxSum = 0, thisSum = 0;
        int up = 0, down =  0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return  maxSum;
    }
    public static void main(String[] args) {
        int a = maxSubSum(new int[] {-4,-3,-5,-2,1,-2,-6,-2});

    }
}
