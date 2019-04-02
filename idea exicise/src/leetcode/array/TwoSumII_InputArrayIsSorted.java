package leetcode.array;

public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;
        while(firstIndex < lastIndex) {
            int sum = numbers[firstIndex] + numbers[lastIndex];
            if (sum == target)
                break;
            else if (sum > target)
                lastIndex--;
            else
                firstIndex++;
        }
        return new int[] {firstIndex + 1, lastIndex + 2};
    }

}
