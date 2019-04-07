package leetcode.array;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        //记住两个最小的数，neg1最小
        int neg1 = Integer.MAX_VALUE, neg2 = Integer.MAX_VALUE;
        //记住三个最大的数, pos1最大
        int pos1 = Integer.MIN_VALUE, pos2 = Integer.MIN_VALUE, pos3 = Integer.MIN_VALUE;
        for (int num : nums) {
            //比最小的数小
            if (num <= neg1) {
                neg2 = neg1;
                neg1 = num;
            } else if (num <= neg2) {  //比第二小的数小
                neg2 = num;
            }
            //比最大的数大
            if (num >= pos1) {
                pos3 = pos2;
                pos2 = pos1;
                pos1 = num;
            } else if (num >= pos2) {  //介于第一大和第二大的数之间
                pos3 = pos2;
                pos2 = num;
            } else if (num >= pos3) {  //比最小的数大，比第二大的数小
                pos3 = num;
            }
        }
        return Math.max(neg1 * neg2 * pos1, pos1 * pos2 * pos3);
    }
}
