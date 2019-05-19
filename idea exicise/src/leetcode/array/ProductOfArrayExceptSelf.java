package leetcode.array;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).(不要使用除法)
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    /**
     * 方法1
     * 求i位置的结果，利用求i左边的数的乘积乘以右边数的乘积
     * 先遍历左边的乘积，l[n]存储, l[0]为1，然后l[i]与nums[i]乘过去
     * 遍历右边的乘积，r[n - 1] 为1，然后r[i] 与n[i]乘过去
     * 最后除去nums[i]的结果是r[i]*l[i]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] res = new int[nums.length];
        l[0] = 1;
        r[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }

    /**
     * 方法2
     * 和上面的方法一个原理，只是不用l和r，直接用res缓存
     * 左边直接存到res中，然后用一个数缓存右边乘积，从右向左遍历存入res中
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 2; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
