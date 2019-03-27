package leetcode.array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int ind = -1;
                //找到下一个不为0的元素的位置
                for (int j = i + 1; j < nums.length; j++)
                    if (nums[j] != 0) {
                        ind = j;
                        break;
                    }
                //交换找到的位置
                if (ind != -1) {
                    nums[i] = nums[ind];
                    nums[ind] = 0;
                }
            }
        }
    }
    public void moveZeroes1(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        for (int index = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                //和index交换位置
                int num = nums[cur];
                nums[cur] = nums[index];
                nums[index] = num;
                index++;
            }
        }
    }
}
