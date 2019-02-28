package linkList.linkedListCycle;
/**
 * 给定一个链表，判断链表中是否有环。
 */

import linkList.ListNode;

import java.util.HashSet;

public class Linked_List_Cycle {
    /**
     * hashSet法，利用hashSet的特性（同一个元素只能存一个），就能找到环
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            } else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Floyd算法(龟兔赛跑)
     *
     * @param head
     * @return
     */
    public boolean hasCycleByDoubleIndex(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast, slow;
        slow = head.next;
        fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }

    /**
     * Brent's Cycle Detection Algorithm (The Teleporting Turtle)
     *
     * @param head
     * @return
     */
    public boolean hasCycleByBrent(ListNode head) {
        ListNode turtle = head;
        ListNode rabbit = head;
        int steps_taken = 0;
        int steps_limit = 2;
        while (true) {
            if (rabbit == null) return false;
            rabbit = rabbit.next;
            steps_taken++;
            if (rabbit == turtle) return true;
            if (steps_taken == steps_limit) {
                steps_taken = 0;
                steps_limit *= 2;
                //传送乌龟，乌龟就是哨点
                turtle = rabbit;
            }
        }
    }

}

