package leetcode.array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    /**
     * 第一想法是从最小的找，但是得用额外的空间，存储被占用位置的数据，想着两个数组交换位置存储，当时很多情况不适合。
     * 改用从最大找，就不占用有效数据的位置，因为空间预留了`nums2`的长度个
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int ind = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[ind] = nums1[i];
                i--;
            } else {
                nums1[ind] = nums2[j];
                j--;
            }
            ind--;
        }
        //i位置的数据一直在nums1上，不用遍历，所以只需移动j的
        while (j >= 0) {
            nums1[ind] = nums2[j];
            j--;
            ind--;
        }
    }
}
