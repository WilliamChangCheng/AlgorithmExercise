package linkList.mergeTwoSortedLinkList;
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 解决思路
 *      利用归并排序思想的合并过程，都不为null进行循环，循环结束后，哪个链表不为空，就把哪个接上
 */
import linkList.ListNode;
import linkList.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    /**
     * 自己的解法，完全依赖与循环
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode res = newList;
        while (l1 != null || l2 != null) {
            boolean l1n = l1 != null;
            boolean l2n = l2 != null;
            if (l1n && l2n ) {
                if (l1.val <= l2.val) {
                    newList.next = l1;
                    newList = newList.next;
                    l1 = l1.next;
                }
                else {
                    newList.next = l2;
                    newList = newList.next;
                    l2 = l2.next;
                }
            }
            else {
                if (!l1n) {
                    newList.next = l2;
                    newList = newList.next;
                    l2 = l2.next;
                }
                else {
                    newList.next = l1;
                    newList = newList.next;
                    l1 = l1.next;
                }
            }
        }
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode res = newList;
        while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    newList.next = l1;
                    newList = newList.next;
                    l1 = l1.next;
                }
                else {
                    newList.next = l2;
                    newList = newList.next;
                    l2 = l2.next;
                }
        }
        //把没合并的加进去就行
        if (l1 != null) newList.next = l1;
        if (l2 != null) newList.next = l2;
        return res.next;
    }
}

public class Merge_two_sorted_linkList {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = Tool.stringToListNode(line);
            line = in.readLine();
            ListNode l2 = Tool.stringToListNode(line);

            ListNode ret = new Solution().mergeTwoLists1(l1, l2);

            String out = Tool.listNodeToString(ret);

            System.out.print(out);
        }
    }
}