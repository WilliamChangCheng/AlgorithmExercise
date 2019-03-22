package leetcode.linkList.swapNodesInPairs;

import leetcode.linkList.ListNode;
import leetcode.linkList.Tool;


import java.io.IOException;



public class SwapNodesinPairs {

    public static void main(String[] args) throws IOException {
        String line = "[1]";

        ListNode head = Tool.stringToListNode(line);

        ListNode ret = new Solution().swapPairs(head);

        String out = Tool.listNodeToString(ret);

        System.out.print(out);
    }

}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode res = cur;
        while (head != null && head.next != null) {
            //第二个节点放到cur后
            cur.next = head.next;
            //第一个指针变成第二个的指针
            head.next = head.next.next;
            //第一个放到第二个节点之后
            cur.next.next = head;
            //节点前移
            head = cur.next.next.next;
            cur = cur.next.next;
        }
        return res.next;
    }
}