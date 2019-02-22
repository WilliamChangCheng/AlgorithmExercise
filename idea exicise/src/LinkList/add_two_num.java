package LinkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;

                }
            }

        }
        return a;

    }

    /**
     * hash两个循环的解法1
     * @param nums 数组
     * @param target 目标值
     * @return 返回元素位置的数组
     */
    public int[] twoSumHash1(int[] nums, int target){
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            temp.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (temp.containsKey(key) && temp.get(key) != i){
               return new int[]  {i, temp.get(key)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * hash一个循环的解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash2(int[] nums, int target){
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int carry = target - nums[i];
            if (temp.containsKey(carry) && temp.get(carry) != i) {
                return  new int[] {i, temp.get(carry)};
            }
            temp.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

class MainClass1 {


    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();   //获取开始时间
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = Tool.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            //int[] ret = new LinkList.Solution1().twoSumHash1(nums, target);
            int[] ret = new Solution1().twoSumHash2(nums, target);
            //int[] ret = new LinkList.Solution1().twoSum(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
            long endTime = System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        }
    }
}
