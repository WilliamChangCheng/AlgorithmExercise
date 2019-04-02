package leetcode.array;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 *
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *
 * 分析
 * 先找频率，记住元素最左最右位置的元素；然后找频率最高的元素位置的差的最小值；
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    //速度太慢，把元素的最最左最右页存上就快乐
    public static int findShortestSubArray(int[] nums) {
        //找到频率最多的元素
        Map<Integer, Integer> set = new HashMap<>();
        int maxFrequency = 1;
        ArrayList<Integer> numsArray = new ArrayList<>();
        for (int num : nums) {
            numsArray.add(num);
            if (set.containsKey(num)) {
                int val = set.get(num) + 1;
                set.replace(num, val);
                //找到最高频率的元素
                maxFrequency = maxFrequency < val ? val : maxFrequency;
            } else
                set.put(num, 1);
        }
        //找出同是最高频率的元素
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int key : set.keySet()) {
            if (set.get(key) == maxFrequency)
                arrayList.add(key);
        }
        //同样多的元素找到最小的长度
        int minLength = nums.length;
        for (int num : arrayList) {
            int firstIndex = numsArray.indexOf(num);
            int lastIndex = numsArray.lastIndexOf(num);
            int length = lastIndex - firstIndex;
            minLength = minLength > length ? length : minLength;
        }
        return minLength + 1;
    }

    public static int findShortestSubArray1(int[] nums) {
        //声明元素最左位置，元素最右位置，元素个数变量
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        //最高频率，初始为1，因为，单个元素出现频率即为1
        int maxFrequency = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = count.getOrDefault(nums[i], 0) + 1;
            count.put(nums[i], val);
            if (left.get(nums[i]) == null) left.put(nums[i], i);
            right.put(nums[i], i);
            maxFrequency = maxFrequency < val ? val : maxFrequency;
        }
        int minLength = nums.length;
        //循环最高频率的元素
        for (int key : count.keySet()) {
            if (count.get(key) == maxFrequency) {
                int len = right.get(key) - left.get(key) + 1;
                minLength = minLength > len ? len : minLength;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int a = findShortestSubArray1(new int[]{1, 2, 2, 4, 5, 1});
    }

}
