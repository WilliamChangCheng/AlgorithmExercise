package leetcode.array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        //如果k大于nums的长度，移动结果相当于k%length的结果
        k = k % nums.length;
        //只要是移动，就一定会改变所有元素的位置，以此来判断是否移动到位
        int count = 0;
        //for循环，处理位置循环回到原位，但是还有元素没移动
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];
            do {
                current = (current + k) % nums.length;
                int temp = nums[current];
                nums[current] = pre;
                pre = temp;
                count++;
            } while (start != current);
        }
    }
    public static void rotate1(int[] nums, int k) {
        k %= nums.length;
        //整体反转
        reverse(nums, 0, nums.length - 1);
        //反转前k个
        reverse(nums, 0, k - 1);
        //反转后n-k个
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        rotate1(new int[] {-1}, 2);
    }
}
