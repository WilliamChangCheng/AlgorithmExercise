package linkList;

/**
 *给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 奇偶链表
 */
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        //偶数节点指针
        ListNode even = head.next;
        //奇数节点指针
        ListNode odd = head;
        //保留偶数节点指针，便于循环完毕后加入奇数节点后
        ListNode evenHead = even;
        while (odd.next != null && even.next != null) {
            //偶数节点后就是奇数节点
            odd.next = even.next;
            //上面奇数节点移动后，奇数指针指向偶数节点后方
            odd = odd.next;
            //同理
            even.next = odd.next;
            even = even.next;
        }
        //奇数节点后加上偶数节点的头节点
        odd.next = evenHead;
        return head;
    }
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

            ListNode ret =  oddEvenList(head);

            long endTime = System.nanoTime(); //获取结束时间

            String out = Tool.listNodeToString(ret);
            System.out.print(out);
            System.out.println("程序运行时间： " + (endTime - startTime) + "ns");

        }
    }
}
