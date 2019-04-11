package leetcode.array;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 */
public class PascalsTriangleII {
    /**
     * 杨辉三角的某行数，数的个数为，行数加1。新建一个长度为行数加一的数组，第一个元素1，然后1行行的累加上去。
     * 如果要求返回的是List，新建一个长度为行数加1的List，每次循环前，都先add个1，正好是$i$行的最后一个元素，然后从后向前累加
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
