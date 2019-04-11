package leetcode.array;

/**
 * 数组代表一个正整数，高位为0位置，此正整数加1的结果输出
 * 因为是加一，当循环过程中进位为0时就代表加法结束了，可以退出，如果未退出，运行到了循环体外，就代表遇见了99加1的示例，
 * 新建一个比原数组长1的数组，然后0位置为1即可，其后一定为0；
 */
public class PlusOne {
    /**
     * 当进位为零时，代表高位不再修改，可以直接返回了。
     * 加1遇到的极端情况，类似于9加1，会超出原数组的长度，需要重现建个数组，比原数组长1个长度，0位置为1，后边的自然为零
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int jinwei = 1;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int temp = digits[i] + jinwei;
            digits[i] = temp % 10;
            jinwei =  temp / 10;
            if (jinwei == 0)
                return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;

    }

    public static void main(String[] args) {
        plusOne(new int[] {1,2,3});
    }

}
