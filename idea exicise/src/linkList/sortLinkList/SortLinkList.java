package linkList.sortLinkList;

import linkList.ListNode;

import linkList.Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class SortLinkList {
    public static void main(String[] args) throws IOException {
//        String line = "[4,2,1,3,4]";
//        ListNode head = Tool.stringToListNode(line);
//        ListNode res = new Solution().sortList(head);
//
//        System.out.println(Tool.listNodeToString(res));


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = Tool.stringToListNode(line);
            long startTime = System.nanoTime();

            ListNode ret = new Solution().insertSort(head);

            long endTime = System.nanoTime(); //获取结束时间

            String out = Tool.listNodeToString(ret);
            System.out.print(out);
            System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        }
    }
}
class Solution {
    public ListNode sortList(ListNode head) {
        TreeSet<ListNode> ts = new TreeSet<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                int num = o1.val - o2.val;
                return num == 0 ? 1 : num;
            }
        });
        while (head != null) {
            ts.add(head);
            head = head.next;
        }
        ListNode node = new ListNode(0);
        ListNode res = node;
        for ( ListNode cur: ts) {
            node.next = cur;
            node = node.next;
        }
        node.next = null;
        return res.next;
    }

    //region 归并排序
    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //fast快指针，slow慢指针，preSlow是slow的前一个节点
        ListNode fast, slow, preSlow = null;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //将中点之前的链表断开
        preSlow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        ListNode res = merge(left, right);
        return res;

    }

    /**
     * 合并两个以排好序的链表
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                res.next = right;
                right = right.next;
            } else {
                res.next = left;
                left = left.next;
            }
            res = res.next;
        }
        if (left != null) res.next = left;
        if (right != null) res.next = right;
        return cur.next;
    }
    //endregion

    /**
     * 插入排序
     * @param head
     * @return
     */
    public ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = new ListNode(head.val);
        ListNode res = cur;
        head = head.next;
        while (head != null) {
            while (cur != null) {
                if (cur.val < head.val) {
                    //插入的节点比列表尾部大, 插在队尾
                    if (cur.next == null) {
                       ListNode temp = new ListNode(head.val);
                       cur.next = temp;
                       break;
                    }
                    cur = cur.next;
                } else {
                    //遇到第一个比head大的点就是要插入的位置，插入后break
                    ListNode temp = new ListNode(cur.val);
                    temp.next = cur.next;
                    cur.val = head.val;
                    cur.next = temp;
                    break;
                }
            }
            head = head.next;
            cur = res;
        }
        return res;
    }
}