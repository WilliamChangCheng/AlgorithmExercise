package leetcode.linkList;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */


public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        //先求链表的长度，然后再用 length-( k%length)求的头节点移动几步
        ListNode res = head;
        //ListNode slow = head, fast = head;
        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        length = length + 1;
        //移动的步数和长度相等的整倍数，代表原来的链表结构，无需移动
        if (k % length == 0) return res;
        //和头部连接起来，组成个圈
        head.next = res;
        //切断的位置
        int move = length - (k % length);
        for (int i = 0; i < move - 1; i++) {
            res = res.next;
        }
        ListNode rs = res.next;
        res.next = null;
        return rs;
    }

    public static void main(String[] args) {
        ListNode line = Tool.stringToListNode("[1,2]");
        ListNode res = rotateRight(line, 1);
        // ListNode ad = Tool.makeCycle("[1,2]", 0);

    }
}
