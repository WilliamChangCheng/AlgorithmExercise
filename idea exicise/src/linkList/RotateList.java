package linkList;

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

    }
}
