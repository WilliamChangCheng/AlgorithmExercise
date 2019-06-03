package leetcode.array;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 * 示例：
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *
 * 提示：
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] height = new int[101];
        for (int hi : height) {
            height[hi]++;
        }
        int res = 0;
        int curheight = 0;
        //比较原来的位置是否是最终位置
        for (int i = 0; i < heights.length; i++) {
            while (height[curheight] == 0) {
                curheight++;
            }
            //身高在一次遍历之后，都排序在了height中，如果现在遍历到了i
            //且heights[i] != curheight，就说明此位置不在排序的位置，就res++
            if (heights[i] != curheight) {
                res++;
            }
            //走一次i减一次，匹配总个数
            height[curheight]--;
        }
        return res;
    }
}
