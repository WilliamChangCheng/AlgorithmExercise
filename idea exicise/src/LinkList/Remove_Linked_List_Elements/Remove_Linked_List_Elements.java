package LinkList.Remove_Linked_List_Elements;

import LinkList.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode link = new ListNode(0);
        link.next = head;
        ListNode res = link;
        while (link.next != null) {
            if (link.next.val == val) {
                link.next = link.next.next;
            }
            else{
                link = link.next;
            }
        }
        return res.next;

    }
}

