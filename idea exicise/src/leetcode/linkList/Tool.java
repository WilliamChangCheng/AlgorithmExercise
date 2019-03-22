package leetcode.linkList;

/**
 * 链表工具类
 */
public class Tool {
    private Tool() {}

    /**
     * 字符串转换为数组
     * @param input
     * @return
     */
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    /**
     * 字符串转换为链表
     * @param input
     * @return
     */
    public static ListNode stringToListNode(String input) {
        // Generate leetcode.array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    /**
     * 链表转换为字符串
     * @param node
     * @return
     */
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

    /**
     * 字符串转换为带圈的链表
     *
     * @param line 符合规则的字符串如 ：[1,2]
     * @param pos  表示链表尾连接到链表中的位置（索引从 0 开始）
     * @return
     */
    public static ListNode makeCycle(String line, int pos) {
        ListNode head = stringToListNode(line);
        if (head == null || pos <= -1) return head;
        ListNode res = head, temp = null;
        int locat = 0;
        while (head.next != null) {
            if (locat == pos) temp = head;
            locat++;
            head = head.next;
        }
        head.next = temp;
        return res;
    }

}
