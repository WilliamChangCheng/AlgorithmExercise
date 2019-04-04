package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public static List<List<Integer>> largeGroupPositions(String S) {
        //给ss加个尾巴，防止最后一组不能记录
        S += 'B';
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        //区别小写字母
        char before = 'A';
        int beforeIndex = 0;
        int i = 0;
        for (char ch : S.toCharArray()) {
            if (ch != before) {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(beforeIndex);
                    temp.add(i - 1);
                    res.add(temp);
                }
                before = ch;
                count = 1;
                beforeIndex = i;
            } else {
                count++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = largeGroupPositions("abbxxxxzzy");
    }
}
