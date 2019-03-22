package leetcode.linkList;
//region 题目
/**
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * 注意:
 *
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 */
//endregion

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 链表组件
 */
public class LinkedListComponents {
    public static int numComponents1(ListNode head, int[] G) {
        int num = 0;
        boolean[] A = new boolean[10000];
        for(int i : G){
            A[i] = true;
        }
        boolean flag = false;
        ListNode p = head;
        while(p != null){
            if(A[p.val]){
                flag = true;
                num++;
            } else {
                if (flag) {
                    num++;
                }
                flag = false;
            }
            p = p.next;
        }

        return num;
    }
    public static int numComponents(ListNode head, int[] G) {
        ListNode curHead = head;
        //利用hashset加快查找是否包含
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i1 : G) {
            hashSet.add(i1);
        }
        int res = 0;
        boolean flag = false;
        while (curHead != null) {
            if (hashSet.contains(curHead.val)) {
                flag = true;
            } else {
                if (flag) {
                    res++;
                }
                flag = false;
            }
            curHead = curHead.next;
        }
        res = flag ? res + 1 : res;
        return res;

    }

    public boolean containNum(int[] g, int num) {
        if (g == null || g.length == 0) return false;
        boolean res = false;
        for (int i = 0; i < g.length; i++) {
            if (g[i] == num) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = Tool.stringToListNode(line);
            int[] g = Tool.stringToIntegerArray(in.readLine());
            long startTime = System.nanoTime();

            int ret = numComponents(head, g);

            long endTime = System.nanoTime(); //获取结束时间

            //String out = Tool.listNodeToString(ret);
            System.out.print(ret);
            System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
        }
    }
}
