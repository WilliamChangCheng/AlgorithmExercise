package linkList;
//reginon 题目
/**
 * 分隔链表
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 * <p>
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */
//endregion

//region 思路

/**
 * 先找到中点，slow走了几步，算出共有多少个节点，这样在分割
 */
//endregion
public class SplitLinkedListInParts {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode temp = root;
        ListNode fast = root, slow = root;
        //找中点
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //slow走一次长度加一次
            length++;
        }
        //fast为空是奇数个，不为空是偶数个
        length = fast != null ? length * 2 + 1 : length * 2;
        int remainder = length % k;
        int ave = length / k;
        //缓存断点的上一个位置
        ListNode pre = temp;
        //两种情况，长度比k长，长度比k短,但都要循环k次
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            res[i] = temp;
            int num = remainder > 0 ? ave + 1 : ave;
            remainder--;
            for (int j = 0; j < num; j++) {
                pre = temp;
                temp = temp.next;
            }
            if (pre != null) pre.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode line = Tool.stringToListNode("[1,2,3,4,5]");
        ListNode[] res = splitListToParts(line, 3);
    }
}


