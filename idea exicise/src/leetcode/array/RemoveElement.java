package leetcode.array;

/**
 * 给一个数组，并给一个值，删除数组中的给定值，然后返回删除元素后的长度，不能用额外空间，在原数组上操作，就是非给定制，全移前边去，然后返回新的长度
 */
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

    /**
     * i指针表明非指定元素的位置，从头开始；j指针前移，找非给定元素，给i元素然后i加加
     * @param nums
     * @param val
     * @return
     */
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

    /**
     * 两个指针，前指针遇到指定值，和后指针交换，后指针减减，再判断前指针是不是给定值，不是就前移前指针
     * @param nums
     * @param val
     * @return
     */
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

