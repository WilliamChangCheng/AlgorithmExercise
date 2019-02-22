package LinkList.Remove_nth_node_from_end_of_list;
/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */

import LinkList.ListNode;
import LinkList.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Solution {
    /**
     * 两指针，一次遍历法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp, seconed = temp;
        //for和while加起来，正好是走了一遍循环，走到first为null
        //第一个指针先走n+1步
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            seconed = seconed.next;
        }
       // seconed.val = seconed.next.val;
        seconed.next = seconed.next.next;
        return temp.next;
    }

    int length = 0;

    /**
     * 递归法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        //加哑节点，以防链表只有一个节点，且删除最后一个
        temp.next = head;
        return deleteNodeFromEnd(temp, n).next;
        //remove(head, n);
        //ListNode n3 = head;

    }
    private ListNode deleteNodeFromEnd(ListNode head, int n) {
        if (head.next == null) return head;
        ListNode newHead = deleteNodeFromEnd(head.next, n);
        length++;
        if (length == n ) {
            //移除head.next的点
            head.next = head.next.next;
        }
//        if ( n == 1 && length == 2) {
//            head.next = null;
//        }
//        if (n == length && n != 1) {
//            // if (newHead.next != null) {
//            head.val = head.next.val;
//            head.next = head.next.next;
//            // }
//        }
        return head;
    }

}

public class Remove_nth_node_from_end_of_list {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = Tool.stringToListNode(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            long startTime=System.nanoTime();

            ListNode ret = new Solution().removeNthFromEnd(head, n);

            long endTime=System.nanoTime(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime - startTime)+"ns");

            String out = Tool.listNodeToString(ret);

            System.out.print(out);
        }
    }
}