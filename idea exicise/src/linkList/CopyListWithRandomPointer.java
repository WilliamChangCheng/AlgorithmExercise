package linkList;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    /**
     * hashMap法，代码提交2ms
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node headValue = head;
        //先放入map
        while (head != null) {
            map.put(head, new Node(head.val, null, null));
            head = head.next;
        }
        while (temp != null) {
            Node cur = map.get(temp);
            cur.next = map.get(temp.next);
            cur.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(headValue);
    }

    public Node copyTandomList1(Node head) {
        if (head == null) return null;
        Node temp = head;
        //建立新节点和老节点连上
        while (temp != null) {
            Node cur = new Node(temp.val, temp.next, null);
            temp.next = cur;
            temp = cur.next;
        }
        //根据老节点random添加新节点random
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }
        temp = head;
        Node res = temp.next;
        //新节点老节点分离
        while (temp != null) {
            Node cur = temp.next;
            temp.next = cur.next;
            //当最后一个节点的特殊情况
            if (cur.next != null) cur.next = temp.next.next;
            temp = temp.next;
        }
        return res;
    }
}
