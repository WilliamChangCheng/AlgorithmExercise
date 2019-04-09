package leetcode.array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        for (int i = 0; i < nums.length && i < last; i++) {
            int num = nums[i];
            if (num == val) {
                while (last >= 0 && nums[last] == val) {
                    last--;
                }
                if (last > i) {
                    nums[i] = nums[last];
                    nums[last] = num;
                    last--;
                }
            }
        }
        return last + 1;
    }
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}

