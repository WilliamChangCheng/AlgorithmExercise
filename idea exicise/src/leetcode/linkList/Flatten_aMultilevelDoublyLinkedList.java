package leetcode.linkList;

import java.util.Stack;

/**
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 */

public class Flatten_aMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 不改变原链表
     *
     * @param head
     * @return
     */
    public static Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node res = new Node(0, null, null, null);
        Node temp = res;
        Node pre = null;
        while (head != null || !stack.empty()) {
            //child为不为空，不为空入栈
            if (head == null) {
                head = stack.pop();
            } else {
                //child不为null,也要先接上
                //next节点接上
                Node cur = new Node(head.val, pre, null, null);
                temp.next = cur;
                //前节点记下来
                pre = cur;
                temp = temp.next;
                if (head.child != null) {
                    //把子节点的下一个节点进栈，先判断为不为null，再进栈
                    stack.push(head.next);
                    head = head.child;
                    continue;
                }
                head = head.next;
            }
        }
        return res.next;
    }

    /**
     * 改变原链表
     *
     * @param head
     * @return
     */
    public static Node flatten2(Node head) {
        Stack<Node> stack = new Stack<>();
        Node res = new Node();
        res.next = head;
        while (head != null) {
            if (head.child != null) {
                if (head.next != null) stack.push(head.next);
                head.next = head.child;
                head.child = null;
                head.next.prev = head;
            } else {
                if (head.next == null && !stack.empty()) {
                    head.next = stack.pop();
                    head.next.prev = head;
                }
            }
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, null, null, null);
        Node head2 = new Node(2, head1, null, null);
        Node head3 = new Node(3, head2, null, null);
        Node head4 = new Node(4, head3, null, null);
        Node head5 = new Node(5, head4, null, null);
        Node head6 = new Node(6, head5, null, null);
        Node head7 = new Node(7, null, null, null);
        Node head8 = new Node(8, head7, null, null);
        Node head9 = new Node(9, head8, null, null);
        Node head10 = new Node(10, head9, null, null);
        Node head11 = new Node(11, null, null, null);
        Node head12 = new Node(12, head11, null, null);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head7.next = head8;
        head8.next = head9;
        head9.next = head10;
        head11.next = head12;
        head3.child = head7;
        head8.child = head11;
        Node res = flatten(head1);

    }
}
