package leetcode.array;

/**
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 *
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 *
 * Note:
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 *
 * 分析
 * 一次遍历，遇见零，i正常循环，遇见1，i在循环体加1（因为前者为1，后者为1为0都满足定义），循环时记住当前数，最后一个为0，就代表满足题意
 */
public class OnebitAndTwobitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int temp = 0;
        for (int i = 0; i < bits.length; i++) {
            temp = bits[i];
            if (bits[i] == 1) {
                i++;
            }
        }
        return temp == 0;
    }

    /**
     * The second-last 0 must be the end of a character (or, the beginning of the array if it doesn't exist).
     * Looking from that position forward, the array bits takes the form [1, 1, ..., 1, 0] where there are zero or more 1's present in total.
     * It is easy to show that the answer is true if and only if there are an even number of ones present.
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }

}


