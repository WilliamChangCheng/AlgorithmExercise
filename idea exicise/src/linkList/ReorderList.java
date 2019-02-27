package linkList;

/**
 * 题目
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 思路;
 * 找中点,然后从中点断开，分成两个链表的思路
 */


public class ReorderList {

    public static void reorderList(ListNode head) {
        ListNode fast = head, slow = head, cur = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转中点之后
        ListNode reverseHead = reverse(slow.next);
        slow.next = null;

        while (reverseHead != null) {
            //缓存要插入的链表的第二个节点
            ListNode revTemp = reverseHead.next;
            reverseHead.next = cur.next;
            cur.next = reverseHead;

            cur = reverseHead.next;
            reverseHead = revTemp;

        }
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode line = Tool.stringToListNode("[1,2,3,4,5]");
        reorderList(line);
    }
}
