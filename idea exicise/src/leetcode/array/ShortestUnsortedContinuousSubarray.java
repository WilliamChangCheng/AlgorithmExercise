package leetcode.array;

public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, minInd = -1;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) flag = true;
            if (flag) {
                min = Math.min(nums[i], min);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int sta = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                sta = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (max > nums[i]) {
                end = i;
                break;
            }
        }
        return end - sta <= 0 ? 0 : end - sta + 1;
    }
    public static int findUnsortedSubarray1(int[] nums) {
        int len = nums.length, sta = -1, end = -2, min = nums[len - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //从前往后遍历， 记录当前最大值，
            max = Math.max(max, nums[i]);
            //从后往前遍历， 记录当前最小值
            min = Math.min(min, nums[len - 1 - i]);
            //当前数比max小时，end=当前下标index
            if (max > nums[i]) end = i;
            //当前数比min大时 start=当前下标index
            if (min < nums[len - 1 - i]) sta = len - 1 - i;
        }
        return end - sta + 1;
    }
    public static void main(String[] args) {
        int a = findUnsortedSubarray(new int[] {1,2,3,4});
    }

}
