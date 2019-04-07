package leetcode.array;
/**
 * 杨辉三角
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        //五行
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int upRight = 0, upleft = 0;
                if (j - 1 >= 0) {
                    upleft = res.get(i - 1).get(j - 1);
                }
                if (j <= i - 1) {
                    upRight = res.get(i - 1).get(j);
                }

                temp.add(upleft + upRight);

            }
            res.add(temp);
        }
        return res;
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            //循环范围不包括头尾，所以只要内部元素一定有j和j-1位置的元素
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        generate1(5);
    }
}
