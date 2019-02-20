package LinkList.Palindrome_linked_list;

import LinkList.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 题目解析：
 * 1.因回文特性，用栈结构
 *      1.如果链表长度是1，为回文
 *      2.如果链表长度为奇数，如[1,0,1]，也是回文结构
 *      3.所以不能单单以链表为奇数就否定
 * 2.用快慢指针法找链表中点（为什么能找到中点，因为，快指针走的步数是慢指针的二倍，，所以慢指针就是中点），然后反转
 *      1.用递归反转。原理：见md图
 *
 * 结果对比
 *      实例[1,0,1]
 *      快慢指针法找链表中点，然后反转，多次运行后是3000ns
 *      栈结构时间多次运行1万ns
 * 结论
 *      大量数据显示，快慢指针中点反转法的速度比栈方法快三倍左右
 *
 */


/**
 * Definition for singly-linked list.
 * public class LinkList.ListNode {
 * int val;
 * LinkList.ListNode next;
 * LinkList.ListNode(int x) { val = x; }
 * }
 */


class Solution {
    /**
     * 用栈解决
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> tempStack = new Stack<Integer>();
        ListNode tempList = head;
        ListNode twoList = head;
        //先求出链表的长度，且是不是2的倍数
        int listLength = 0;
        while (tempList != null) {
            listLength++;
            tempList = tempList.next;
        }
        //看长度是否是2的倍数，不能代表回文
        //if (listLength % 2 != 0) return false;

        //入栈入一半
        for (int i = 0; i < listLength / 2; i++) {
            tempStack.push(twoList.val);
            twoList = twoList.next;
        }
        //看长度是奇数还是偶数,如果是奇数，链表后移一个
        if (listLength % 2 != 0) twoList = twoList.next;


        //出栈比对
        while (twoList != null) {
            if (twoList.val != tempStack.pop()) return false;
            twoList = twoList.next;
        }
        return true;
    }

    /**
     * 快慢指针法找链表中点，然后反转
     * 为什么能找到中点，因为，快指针走的步数是慢指针的二倍，，所以慢指针就是中点
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        //一个或为空时是回文
        if (head == null || head.next == null) return true;
        //快慢指针
        ListNode fast = head, slow = head, temp = head;
        //找中点,奇数个，slow就是中点，偶数个slow就是中点的前一个
//        while (slow.next != null && fast.next.next != null) {
        //fast先走，slow不用考虑为空，fast先找到空。fast.next != null是防止奇数情况下，另一个是防止偶数情况下
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        slow = reverse(slow.next);
        while (slow != null) {
            if (temp.val != slow.val) return false;
            temp = temp.next;
            slow = slow.next;
        }
        return true;


    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        //最后一个点的标志是next为空
        if (head.next == null ) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            //LinkList.ListNode head = stringToListNode("[1,0,1]");

            long startTime=System.nanoTime();   //获取开始时间
//            boolean ret = new Solution().isPalindrome(head);
            boolean ret = new Solution().isPalindrome1(head);
            long endTime=System.nanoTime(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime - startTime)+"ns");
            String out = booleanToString(ret);
            //LinkList.ListNode test = new Solution().reverse(head);
            System.out.print(out);


        }
    }
}


