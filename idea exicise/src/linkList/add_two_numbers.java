package linkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */


class Solution {
    //自己想的方法

    /**
     * 自己写方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l, l3;
        int jin = l1.val + l2.val > 9 ? 1 : 0;
        //第一个这样写，是因为要保留表头
        l3 = l = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                l.next = new ListNode((l1.val + l2.val + jin) % 10);
                //进位
                jin = l1.val + l2.val + jin > 9 ? 1 : 0;
                //单独换l1等的地址，以防其中一个已为空
                l1 = l1.next;
                l2 = l2.next;
                l = l.next;
            } else {
                if (l1 == null && l2 != null) {
                    l.next = new ListNode((l2.val + jin) % 10);
                    //防止加上进位后有进位
                    jin = l2.val + jin > 9 ? 1 : 0;
                    //单独换l1等的地址，以防其中一个已为空
                    l2 = l2.next;
                    l = l.next;
                } else {
                    l.next = new ListNode((l1.val + jin) % 10);
                    //防止加上进位后有进位
                    jin = l1.val + jin > 9 ? 1 : 0;
                    //单独换l1等的地址，以防其中一个已为空
                    l1 = l1.next;
                    l = l.next;
                }
            }
            //不能这样写，当一个为null时，就会报错
//            l1 = l1.next;
//            l2 = l2.next;
//            l = l.next;
        }
        //当最高位有进位时，要补上一个点
        if (jin > 0) {
            l.next = new ListNode(1);
        }
        return l3;

    }

    /**
     * 官方解答方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addnum(ListNode l1, ListNode l2){
        ListNode head, temp, p = l1, q = l2;
        int carry = 0;
        head = temp = new ListNode(0);

        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum /10;
            temp = temp.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if (carry > 0){
            temp.next = new ListNode(carry);
        }
        return head.next;

    }
}

class MainClass {


    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();   //获取开始时间
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = Tool.stringToListNode(line);
            line = in.readLine();
            ListNode l2 = Tool.stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);
            //linkList.ListNode ret = new linkList.sortLinkList.Solution().addnum(l1, l2);
            String out = Tool.listNodeToString(ret);

            System.out.print(out);
            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
        }
    }
}

