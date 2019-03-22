package leetcode.linkList;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class ReverseNodes_in_k_Group {
    /**
     * 一次循环法，总共循环n+k次
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        res.next = head;
        ListNode start = temp, pre = temp, preStart = temp;
        int count = 0;
        while (temp != null) {
            //遇到k的倍数时的后一个就是start的开始，就是翻转后的end
            ListNode cur = temp.next;
            if ((count - 1) % k == 0) {
                //此时pre是一组的最后一个节点
                //前一个start，链接pre，后一个start，链接当前节点，完成翻转
                preStart.next = pre;
                start.next = temp;
                //前一个start和后一个start前移
                preStart = start;
                start = temp;
            } else {
                //不到第k个节点，就翻转
                temp.next = pre;
            }
            pre = temp;
            temp = cur;
            count++;
        }
        //当最后一个不满足k个时，就要还原做的前后节点翻转
        if ((count - 1) % k != 0) {
            //temp暂做节点缓存
            while (pre != start) {
                preStart = pre.next;
                pre.next = temp;
                temp = pre;
                pre = preStart;
            }
        } else {
            //最后一个满足k个，但是在上个循环未完成前后链接，在这链接
            preStart.next = pre;
            start.next = temp;
        }
        return res.next;

    }

    /**
     * 递归法翻转k个一组（也是最多循环n+k次）
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode cur = head;
        //数出前k个
        for (int i = 0; i < k; ++i) {
            if (cur == null) return head;
            cur = cur.next;
        }
        ListNode newHead = reverse(head, k);
        head.next = reverseKGroup1(cur, k);
        return newHead;
    }

    /**
     * 从head开始，翻转k个（链表长度大于等于k个）
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverse(ListNode head, int k) {
        ListNode temp = null;
        ListNode cur = null;
        while (k > 0) {
            cur = head.next;
            head.next = temp;
            temp = head;
            head = cur;
            k--;
        }
        //最后temp拿到最后一个节点
        return temp;
    }


    public static void main(String[] args) {
        ListNode line = Tool.stringToListNode("[1,2,3,4,5]");
        ListNode res = reverseKGroup1(line, 3);
    }
}
