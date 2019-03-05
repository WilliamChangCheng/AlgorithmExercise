package linkList;

import java.util.Comparator;
import java.util.PriorityQueue;

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


    /**
     * 优先队列方式
     * Time complexity : O(Nlogk) where k is the number of linked lists.
     * The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
     * There are N nodes in the final linked list.
     * <p>
     * Space complexity :
     * O(n) Creating a new linked list costs O(n) space.
     * O(k) The code above present applies in-place method which cost O(1) space.
     * And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            //o1减o2是小顶堆，反之是大顶堆
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (ListNode l : lists) {
            if (l != null) p.add(l);
        }
        while (!p.isEmpty()) {
            ListNode ele = p.poll();
            ListNode cur = new ListNode(ele.val);
            temp.next = cur;
            ele = ele.next;
            temp = temp.next;
            if (ele != null) {
                p.add(ele);
            }
        }
        return head.next;
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
        ListNode res = mergeKLists3(line);

    }
}
