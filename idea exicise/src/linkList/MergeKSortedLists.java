package linkList;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = null;
        int i = 0;
        for (; i < lists.length; i++) {
            if (lists[i] != null) {
                res = lists[i];
                i++;
                break;
            }
        }
        ListNode temp = res;
        ListNode pre = temp;

        for (; i < lists.length; i++) {
            if (lists[i] == null) continue;
            while (temp != null) {
                if (temp.val > lists[i].val) {
                    ListNode cur = new ListNode(temp.val);
                    cur.next = temp.next;
                    temp.val = lists[i].val;
                    temp.next = cur;
                    lists[i] = lists[i].next;
                    if (lists[i] == null) break;
                }
                pre = temp;
                temp = temp.next;
            }
            if (lists[i] != null) pre.next = lists[i];
            temp = res;
        }
        return res;
    }

    /**
     * 非递归两两链接，如果是0和剩下的项链接就会特别慢，慢到10多倍
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = null;
        int k = lists.length;
        while (k > 1) {
            for (int i = 0; i < k / 2; i++) {
                lists[i] = merag2(lists[i], lists[i + (k + 1) / 2]);
            }
            k = (k + 1) / 2;
        }
        return lists[0];


    }

    /**
     * 有序链接两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merag2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;
        return head.next;
    }

    /**
     * 递归法
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        int len = lists.length;
        return fun(lists, 0, len - 1);

    }

    public static ListNode fun(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = (end + start) / 2;
        ListNode node1 = fun(lists, start, mid);
        ListNode node2 = fun(lists, mid + 1, end);
        return merag2(node1, node2);
    }

    public static void main(String[] args) {
        ListNode l1 = Tool.stringToListNode("[1,4,5]");
        ListNode l2 = Tool.stringToListNode("[1,3,4]");
        ListNode l3 = Tool.stringToListNode("[2,6]");
        ListNode l4 = Tool.stringToListNode("[9,10,11]");
//        ListNode l1 = Tool.stringToListNode("[2]");
//        ListNode l2 = Tool.stringToListNode("[]");
//        ListNode l3 = Tool.stringToListNode("[-1]");
        ListNode[] line = {l1, l2, l3, l4};
        ListNode res = mergeKLists2(line);

    }
}
