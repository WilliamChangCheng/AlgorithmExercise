package leetcode.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        int num = 0;
        if (nums.length > 0) num = nums[0];
        else return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                length++;
                nums[length] = nums[i];
                num = nums[i];
            }

        }
        return length + 1;
    }
    //记长度的变量正好作为不等于的标志
    public int removeDuplicates1(int[] nums) {
        int length = 0;
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[length]) {
                length++;
                nums[length] = nums[i];
            }
        }
        return length + 1;
    }
}
