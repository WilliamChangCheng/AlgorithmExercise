package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an leetcode.array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 *
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the leetcode.array will be in the range of [-10000, 10000].
 *
 * 分析
 * 利用26个小写字母，建立一个长度为26的`int`数组s，让字符串中的字母减去字母`a`,
 * 得到一个0到26的数字b，存在`s[b] += 1`， 再比较下一个建立的数组，同个位置，取最小值就是重复的字母个数。
 * 最后对位置上的数据如果大于0，就位置`i + 'a'`, 数字为几，就输出几个，就得到了所有字符串重复的字母数
 */

public class FindCommonCharacters {
    static class Solution {
        //自己想的，但是有三重循环，所以很慢
        public  List<String> commonChars(String[] A) {
            String temp = A[0];;
            for (int i = 1; i < A.length; i++) {
                char[] chars = A[i].toCharArray();
                String s = "";
                for (char c : chars) {
                    int index = -1;
                    if((index = temp.indexOf(c + "")) != -1) {
                        s += c;
                        String a = temp.substring(0, index);
                        temp = a + temp.substring(index + 1, temp.length());
                    }
                }
                temp = s;
            }
            List<String> res = new ArrayList<>();
            for(int i = 0; i < temp.length(); i++) {
                res.add(temp.charAt(i) + "");
            }
            return res;

        }

        /**
         * 得到共同字母，两重循环
         * @param A
         * @return
         */
        public List<String> commonChars1(String[] A) {
            int[] sou = convertCharToArray(A[0]);
            List<String> res = new ArrayList<>();
            for (int i = 1; i < A.length; i++)
                sou = commonChars(sou, convertCharToArray(A[i]));
            for (int i = 0; i < sou.length; i++) {
                for (int j = sou[i]; j > 0; j--) {
                    res.add((char)(i + 'a') + "");
                }
            }
            return res;
        }
        //字符串转换为数组
        int[] convertCharToArray(String s) {
            int[] res = new int[26];
            for (char c : s.toCharArray()) {
                res[c - 'a'] += 1;
            }
            return res;
        }
        //比较来个数组共同之母
        int[] commonChars(int[] sou, int[] tar) {
            for (int i = 0; i < sou.length; i ++) {
                //最小的数就是共同的字母数量
                sou[i] = Math.min(sou[i], tar[i]);
            }
            return sou;
        }
    }
    public static void main(String[] args) {
        List<String> a = new Solution().commonChars1(new String[] {"cool","lock","cook"});
    }

}
