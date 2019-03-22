package leetcode.linkList;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */


public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mhead = head, nhead = new ListNode(0);
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        int i = 0;
        while (temp.next != nhead) {
            if (i == m - 1) mhead = temp;
            if (i == n) {
                //走到n时，把游标切换到mhead位置，接着循环
                nhead = temp;
                temp = mhead;
            }

            if (i >= n) {
                //把temp.next插入到到n所在节点的位置后边
                ListNode cur = nhead.next;
                ListNode tempNext = temp.next;
                nhead.next = temp.next;
                temp.next = temp.next.next;
                tempNext.next = cur;
            }
            i++;
            if (i <= n) temp = temp.next;
        }
        return res.next;
    }

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode mpre = res;
        //找m前一个节点
        for (int i = 0; i < m - 1; i++) {
            mpre = mpre.next;
        }
        //最初为mpre后一个点
        ListNode cur = mpre.next;
        //最初为mpre后第二个点
        ListNode curn = cur.next;
        //最初为mpre后第三个点
        ListNode curnn = curn.next;
        for (int i = 0; i < n - m; i++) {
            //反转后一个点和后两个点，后二连接后一
            curnn = curn.next;
            curn.next = cur;
            //指针后移
            cur = curn;
            curn = curnn;
        }
        //最终curn落在第n个后面的点，cur落在第n个点
        mpre.next.next = curn;
        mpre.next = cur;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode line = Tool.stringToListNode("[1,2,3,4,5]");
        ListNode res = reverseBetween1(line, 1, 4);

    }

}
