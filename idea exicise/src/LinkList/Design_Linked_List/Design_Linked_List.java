package LinkList.Design_Linked_List;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Design_Linked_List {
    public static void main(String[] args) throws ClassNotFoundException {

        //region 反编译
        Class<?> clazz = Class.forName("LinkList.Design_Linked_List.MyLinkedList");
        Method[] methods = clazz.getMethods();
        Map<String, Method> map = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            map.put(methods[i].getName(), methods[i]);
        }
        //endregion

        MyLinkedList link = new MyLinkedList();

        int a = link.get(0);
        link.addAtIndex(1,2);
        int b = link.get(0);
        int c = link.get(1);
        link.addAtIndex(0,1);
        int d = link.get(0);
        int e = link.get(1);

//        link.addAtHead(7);
//        link.addAtHead(2);
//        link.addAtHead(1);
//
//        //link.addAtTail(3);
//        link.addAtIndex(3, 0);
//        link.deleteAtIndex(2);
//        link.addAtHead(6);
//        link.addAtTail(4);
//        //link.addAtIndex(0, 5);
//        int a = link.get(4);
        //link.deleteAtIndex(1);
//        int b = link.get(0);
//        int c = link.get(2);

        boolean flag = true;
    }



}

class MyLinkedList {


    private int val;
    private MyLinkedList next;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.val = -1;
        //next = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) return -1;
        if (index == 0 && this.val == -1) return -1;
        MyLinkedList head = new MyLinkedList();
        head.next = next;
        head.val = this.val;
        for (int i = 0; i < index; i++) {
            if (head == null) return -1;
            head = head.next;
        }
        return head != null ? head.val : -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        //未有头
        if (this.val == -1) {
            this.val = val;
        } else {
            MyLinkedList cur = new MyLinkedList();
            //把头部变成函数的val，也不能丢原有的链表，所欲转换下

            cur.val = this.val;
            cur.next = this.next;
            //转换头部
            this.val = val;
            this.next = cur;
        }

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        //链表无节点
        if (this.val == -1) {
            this.val = val;
        }
        //链表只有一个节点
        else if (this.next == null) {
            MyLinkedList cur = new MyLinkedList();
            cur.val = val;
            this.next = cur;
        } else {
            //链表已有两个及以上个节点
            MyLinkedList head = new MyLinkedList();
            //只需要头节点的next
            head.next = next;
            while (head.next != null) {
                head = head.next;
            }
            //新建点，赋值
            head.next = new MyLinkedList();
            head.next.val = val;
//        MyLinkedList cur = new MyLinkedList();
//        cur.val = val;
//        //cur.next = null;
//        head.next = cur;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 ) return;
        if (index == 0) {
            //添加在头部
            addAtHead(val);
        }
        //防止链表为空
        if (this.val == -1) return;
        if (index == 1) {
            if (this.next == null) {
                MyLinkedList cur = new MyLinkedList();
                cur.val = val;
                this.next = cur;
            } else {
                MyLinkedList cur = new MyLinkedList();
                cur.val = val;
                cur.next = this.next;
                this.next = cur;
            }
        }
        if (index > 1) {
            MyLinkedList head = new MyLinkedList();
            head.next = next;
            for (int i = 0; i < index - 1; i++) {
                if (head.next == null) return;
                head = head.next;
            }
            MyLinkedList cur = new MyLinkedList();
            cur.val = val;
            cur.next = head.next;
            head.next = cur;

        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        //第0个和第1个位置特殊，必须在链表头操作
        if (index == 0 || index == 1) {
            //非空链表
            if (this.val != -1) {
                if (index == 0) {
                    this.val = next.val;
                    this.next = next.next;
                } else {
                    this.next = this.next != null ? this.next.next : null;
                }

            }
        }
        //大与1的情况
        if (index > 1) {
            MyLinkedList head = new MyLinkedList();
            head.val = this.val;
            head.next = next;
            //得知道前一个点，否则如果是删的最后一个点，会导致删不掉
            for (int i = 0; i < index - 1; i++) {
                //index超出长度
                if (head.next == null) return;
                head = head.next;
            }
            //index不超出长度
            if (head.next != null) {
                head.next = head.next.next;
            }
        }

    }
}