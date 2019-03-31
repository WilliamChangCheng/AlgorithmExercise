package leetcode.array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int a : nums) {
            if (count == 0) {
                num = a;
            }
            count += num == a ? 1 : -1;
        }
        return num;
    }
}
