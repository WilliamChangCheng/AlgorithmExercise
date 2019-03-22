package leetcode.linkList;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<ListNode> l1s = new Stack<>();
        Stack<ListNode> l2s = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1s.push(l1);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2s.push(l2);
                l2 = l2.next;
            }
        }
        ListNode res = new ListNode(0);
        //ListNode cur = res;

        int sum = 0;
        while (!l1s.empty() || !l2s.empty()) {
            if (!l1s.empty()) sum += l1s.pop().val;
            if (!l2s.empty()) sum += l2s.pop().val;
            res.val = sum % 10;
            ListNode temp = new ListNode(sum /= 10);
            temp.next = res;
            res = temp;
        }
        return res;
        //方法二 带进位标志的
//        int jinwei = 0;
//        int sum = 0;
//        while (!l1s.isEmpty() || !l2s.isEmpty()) {
//            int x = !l1s.isEmpty() ? l1s.pop().val : 0;
//            int y = !l2s.isEmpty() ? l2s.pop().val : 0;
//            sum = x + y + jinwei;
//            jinwei =sum / 10;
//            ListNode temp = new ListNode(sum % 10);
//            temp.next = cur.next;
//            cur.next = temp;
//        }

//        while (!l1s.isEmpty() && !l2s.isEmpty()) {
//            //都有值的情况下
//            sum = l1s.pop().val + l2s.pop().val + jinwei;
//            jinwei =sum / 10;
//            ListNode temp = new ListNode(sum % 10);
//            temp.next = cur.next;
//            cur.next = temp;
//        }
//        while (!l1s.isEmpty()) {
//            sum = jinwei + l1s.pop().val;
//            jinwei = sum /10;
//            ListNode temp = new ListNode(sum % 10);
//            temp.next = cur.next;
//            cur.next = temp;
//        }
//        while (!l2s.isEmpty()) {
//            sum = jinwei + l2s.pop().val;
//            jinwei = sum /10;
//            ListNode temp = new ListNode(sum % 10);
//            temp.next = cur.next;
//            cur.next = temp;
//        }
//        if (jinwei > 10) {
//            ListNode temp = new ListNode(jinwei);
//            temp.next = cur.next;
//            cur.next = temp;
//        }

    }

    public static void main(String[] args) {
        ListNode l1 = Tool.stringToListNode("[7,2,4,3]");
        ListNode l2 = Tool.stringToListNode("[0]");
        ListNode res = addTwoNumbers(l1, l2);
    }
}
