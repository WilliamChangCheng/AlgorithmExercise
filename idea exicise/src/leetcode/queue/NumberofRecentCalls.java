package leetcode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {
    /**
     * 最近请求
     * 分析：
     * 题目要就最多调用1万次，就是说用数组最多存到1万个位置，不用前移数据，移动指针就行，移动前指针和后指针，中间就是要的数据
     * 查找方法用二分查找速度快，但是实例数据太少，用二分到是最慢的
     */
    class RecentCounter {
        /**
         * 记录ping得值
         */
        int[] queue = new int[10000];
        /**
         * 记录有多少条ping值数据
         */

        int start = 0;
        int end = -1;

        public RecentCounter() {
        }

        public int ping(int t) {
            end++;
            queue[end] = t;
            find(t - 3000);
            return end - start + 1;
        }


        private void find1(int val) {
            for (; start < end; start++) {
                if (queue[start] >= val) {
                    return;
                }
            }
        }

        /**
         * 二分查找val的位置
         *
         * @param val
         */
        private void find(int val) {
            int begin = start;
            int stop = end;
            int mid = -1;
            //根据题意，若val小于1代表无此值
            if (val >= 1) {
                if (queue[begin] < val) {
                    while (begin != stop) {
                        mid = (stop - begin) / 2 + begin;
                        if (queue[mid] > val) {
                            stop = mid - 1;
                        } else {
                            if (queue[mid] < val) {
                                //小于val
                                begin = mid + 1;
                            } else {
                                start = mid;
                                return;
                            }
                        }

                    }
                    //查看begin与stop相遇的点是否可留下
                    if (queue[begin] < val) {
                        start = begin + 1;
                    } else {
                        start = begin;
                    }
                }
            }
        }

    }

    //队列实现
    class RecentCounter1 {


        Queue<Integer> queue = new LinkedList<>();

        public RecentCounter1() {
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }

    }

    public static void main(String[] args) {
        int[] a = new int[100];
        a[0] = 100;
        int b = a.length;
        HashSet<Integer> c = new HashSet<>();
        int AG = 'A';

    }
}
