package linkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */

public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) throws IOException {
//        ListNode line = Tool.stringToListNode("[1,1,2,3,3]");
//        ListNode res = deleteDuplicates2(line);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = Tool.stringToListNode(line);
            long startTime = System.nanoTime();

            ListNode ret = deleteDuplicates1(head);

            long endTime = System.nanoTime(); //获取结束时间

            String out = Tool.listNodeToString(ret);
            System.out.print(out);
            System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        }
    }

    /**
     * 自己写的，太罗嗦
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        int num = head.val - 1;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        ListNode preTemp = res;
        while (head != null) {
            //若果等于上一次记的数
            if (head.val == num) {
                //下一个数前移到temp位置，检查temp位置数据是否改变，未改变就接着前移
                while (temp.val == num) {
                    if (temp.next != null) {
                        temp.val = temp.next.val;
                        temp.next = temp.next.next;
                    } else {
                        preTemp.next = null;
                        return res.next;
                    }

                }
                num = temp.val;
                head = temp.next;
            } else {
                //temp前移,前移之前先给pretemp，防止尾部数据是重复数据
                preTemp = temp;
                temp = head;
                //从新记录
                num = head.val;
                head = head.next;
            }

        }
        return res.next;
    }

    /**
     * 不罗嗦的循环
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode temp = new ListNode(head.val - 1);//防止哑节点和头节点一样
        temp.next = head;
        head = temp;
        ListNode left, right;
        while (temp.next != null) {
            left = temp.next;
            right = left;
            while (right.next != null && right.next.val == left.val) {
                right = right.next;
            }
            if (left == right) temp = temp.next;
            else temp.next = right.next;
        }
        return head.next;
    }

    /**
     * 递归法（和循环法差不多）
     * 很难理解
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
        }

        return head;
    }

}
