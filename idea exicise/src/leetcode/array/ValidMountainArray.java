package leetcode.array;

public class ValidMountainArray {
    //这个方法太慢，判断太多
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int peekCount = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i + 1] < A[i]) {
                peekCount++;
            }
            //找到山顶后，以后的点必须是降序
            if (peekCount >= 1 && A[i + 1] >= A[i]) {
                return false;
            }
            //找到山顶之前，以后的点必须是升序的
            if (peekCount < 1 && A[i - 1] >= A[i]) {
                return false;
            }
        }
        return peekCount == 1;
    }
    //两个人爬山，一格从左边，一个从右边，有山顶总会相遇与一点
    public boolean validMountainArray1(int[] A) {
        int len = A.length, i = 0, j = len - 1;
        while (i + 1 < len && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j] < A[j - 1]) j--;
        return i > 0 && i == j && j < len - 1;
    }

}
