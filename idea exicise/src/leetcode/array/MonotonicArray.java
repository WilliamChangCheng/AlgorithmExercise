package leetcode.array;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 *
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 *
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 *
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 *
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 *
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 * 分析
 * 主要的问题是无法确定是升序单调还是降序单调，既然分不了，那就只证明它不单调就可以，不单调就是，升序降序都有的情况
 */
public class MonotonicArray {
    //自己想的，跟下面的方法类似，但下面的方法更简洁
    public boolean isMonotonic(int[] A) {
        boolean flag = false;
        //找出升序还是降序
        flag = A[A.length - 1] - A[0] >= 0;
        for (int i = 1; i < A.length; i++) {
            int num = A[i] - A[i - 1];
            //0继续是因为0不大于0也不小于零，影响结果
            if (num == 0) continue;
            boolean temp = num >= 0;
            //判断是否和初始单调一样，不一样就是不单调的
            if (temp != flag) return false;
        }
        return true;
    }
    //判断是否是不单调的
    public boolean isMonotonic1(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            //不单调肯定既有大于又有小于
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }
        return increasing || decreasing;
    }

    public boolean isMonotonic2(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                //剔除store！= 0是为了去除store的值没动过的情况，即初始情况
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }
        return true;
    }
}
