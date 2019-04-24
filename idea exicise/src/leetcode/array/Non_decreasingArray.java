package leetcode.array;

/**
 * - 题目
 *   改变数组的一个数或0个数，使数组成为升序数组或同元素数组；
 * - 分析
 *   当数组出现两次`nums[i] > nums[i + 1]`及以上时，只修改一次无法实现非降序排序；
 *   当数组没有出现`nums[i] > nums[i + 1]`情况时，直接返回true
 *   当数组出现了一次时要判断以下情况：（除以下情况外，皆返回false）
 *   1. 当记下的index等于0或数组长度减2时，满足一次修改达到目的
 *   2. 当index元素在`index - 1`和`index + 1`中间时，满足要求，如`[3,4,2,3]`
 *   3. 当index元素小于等于`index + 2`时，满足要求，如`[2,3,3,2,4]`
 */
public class Non_decreasingArray {
    //[3,4,2,3],数多少个nums[i] > nums[i + 1]失败的例子count等于1，但是无法只修改一个就目的
    //[2,3,3,2,4]改变一个可以满足条件，加上一个nums[index] <= nums[index + 2]
    public static boolean checkPossibility(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (index != -1) return false;
                index = i;
            }
        }
        return index == -1 || index == 0 || index == nums.length - 2 || nums[index - 1] <= nums[index + 1] || nums[index] <= nums[index + 2];
    }

    public static boolean checkPossibility1(int[] nums) {
        if (nums.length < 3) return true;
        // 思路如下：
        // 如果出现 a[i] > a[i+1]   改变一个数 就面临两种选择
        // 1. 把a[i]变大
        // 2. 把a[i+1] 变小
        // 这两种选择其实是有依据的 需要比较a[i-1] 与 a[i+1]的值
        // eg.  ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
        // 改变完之后，记录改变次数，再检测是否升序
        // 如果次数大于1，至少改了两次 返回false

        // 先让前两个有序
        // 因为没有左边没有数 所以对于前两个数来说，最佳选择就是吧 a[0] 变小
        int changeCount = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            changeCount++;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int right = nums[i+1];
            if (nums[i] > right) {
                changeCount++;
                if (changeCount > 1) {
                    // 后面不用再看了
                    return false;
                }
                int left = nums[i-1];
                if (left > right) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = left;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a = checkPossibility(new int[] {-1,4,2,3});
    }
}
