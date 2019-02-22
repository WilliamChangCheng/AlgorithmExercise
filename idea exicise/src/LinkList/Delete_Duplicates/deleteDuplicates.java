package LinkList.Delete_Duplicates;
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

import LinkList.ListNode;
import LinkList.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode newList = head;
//        Map<Integer, Integer> has = new HashMap<>();
//        while (head != null) {
//            if
//        }
        while (newList != null && newList.next != null) {

            if (newList.val == newList.next.val) {
                newList.next = newList.next.next;
            }
            else {
                newList = newList.next;
            }

        }
        return head;
    }

    /**
     * 嵌套循环法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = head;
//        Map<Integer, Integer> has = new HashMap<>();
//        while (head != null) {
//            if
//        }
        while (newList != null && newList.next != null) {

            while (newList.next != null && newList.val == newList.next.val) {
                newList.next = newList.next.next;
            }
            newList = newList.next;
        }
        return head;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);
        one.next = head;
        two.next = head.next;
        while (one != null) {
            if (one == two.next) {
                return true;
            }
            else {
                one = one.next;
                two = two.next;
            }
        }
        return false;

    }
}


public class deleteDuplicates {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = Tool.stringToListNode(line);

            ListNode ret = new Solution().deleteDuplicates(head);

            String out = Tool.listNodeToString(ret);

            System.out.print(out);
        }
    }
}