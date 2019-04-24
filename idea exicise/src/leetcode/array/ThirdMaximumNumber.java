package leetcode.array;

/**
 * 找出第三个最大的数，如果两个数是相等的，只算一个，如5,2,2，第三大的没有，如果第三大的没有，就从前两个中选最大的
 * 给的数组有可能超过int的最小值
 */
public class ThirdMaximumNumber {
    /**
     * 用long缓存，绕过数组的int最小值，返回时再取int
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        long fir = Long.MIN_VALUE, sec = fir, thi = fir;
        boolean flag = false;
        for (int num : nums) {
            if (num > fir) {
                thi = sec;
                sec = fir;
                fir = num;
            } else if (num < fir){
                if (num > sec) {
                    thi = sec;
                    sec = num;
                } else if (num < sec) {
                    if (num > thi){
                        thi = num;
                    }
                }
            }
        }
        return thi == Long.MIN_VALUE ? (int)Math.max(fir, sec): (int)thi;
    }

    public static void main(String[] args) {
        int a = thirdMax(new int[]{1,2,2,5,3,5});
    }
}
