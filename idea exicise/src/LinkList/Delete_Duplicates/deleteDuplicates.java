package LinkList.Delete_Duplicates;
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

import LinkList.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode newList = head;
//        Map<Integer, Integer> has = new HashMap<>();
//        while (head != null) {
//            if
//        }
        while (newList != null && newList.next != null) {

            if (newList.val == newList.next.val) {
                newList.next = newList.next.next;
            }
            else {
                newList = newList.next;
            }

        }
        return head;
    }

    /**
     * 嵌套循环法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = head;
//        Map<Integer, Integer> has = new HashMap<>();
//        while (head != null) {
//            if
//        }
        while (newList != null && newList.next != null) {

            while (newList.next != null && newList.val == newList.next.val) {
                newList.next = newList.next.next;
            }
            newList = newList.next;
        }
        return head;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);
        one.next = head;
        two.next = head.next;
        while (one != null) {
            if (one == two.next) {
                return true;
            }
            else {
                one = one.next;
                two = two.next;
            }
        }
        return false;

    }
}


public class deleteDuplicates {
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

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().deleteDuplicates(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}