package linkList.sortLinkList;

import linkList.ListNode;
import linkList.Tool;

import java.util.Comparator;
import java.util.TreeSet;

public class SortLinkList {
    public static void main (String[] args) {
        String line = "[4,2,1,3,4]";
        ListNode head = Tool.stringToListNode(line);
        ListNode res = new Solution().sortList(head);

        System.out.println(Tool.listNodeToString(res));
    }


}
class Solution {
    public ListNode sortList(ListNode head) {
        TreeSet<ListNode> ts = new TreeSet<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                int num = o1.val - o2.val;
                return num == 0 ? 1 : num;
            }
        });
        while (head != null) {
            ts.add(head);
            head = head.next;
        }
        ListNode node = new ListNode(0);
        ListNode res = node;
        for ( ListNode cur: ts) {
            node.next = cur;
            node = node.next;
        }
        node.next = null;
        return res.next;
    }
}