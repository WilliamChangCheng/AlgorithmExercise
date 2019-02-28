package linkList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 */


public class LinkedListCycle2 {
    /**
     * hashSet求开始入环的第一个节点
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        //存储节点
        Set<ListNode> hashSet = new HashSet<>();
        ListNode res = null;
        while (head != null) {
            if (hashSet.contains(head)) {
                res = head;
                break;
            } else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return res;
    }

    /**
     * 快慢指针法找环，证明有环后再找环的入口
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode line = Tool.makeCycle("[1]", -1);
        ListNode res = detectCycle(line);
    }

}
