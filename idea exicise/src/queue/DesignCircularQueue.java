package queue;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 */

public class DesignCircularQueue {

    /**
     * 循环队列
     */
    static class MyCircularQueue {
        int[] queue;
        /**
         * 队头
         */
        int head = 0;
        /**
         * 队尾
         */
        int tail = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            //多出的空间用来标志队满
            queue = new int[k + 1];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            //判断队是否为满，不满再插入
            boolean res = false;
            if (!isFull()) {
                queue[tail] = value;
                tail = (tail + 1) % queue.length;
                res = true;
            }
            return res;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            boolean res = false;
            //队列不为空
            if (head != tail) {
                head = (head + 1) % queue.length;
                res = true;
            }
            return res;
        }

        /**
         * Get the front item from the queue.不删除元素
         */
        public int Front() {
            int res = -1;
            if (!isEmpty()) {
                res = queue[head];
                //head = (head + 1) % queue.length;
            }
            return res;
        }

        /**
         * Get the last item from the queue. 只读取并不删除
         */
        public int Rear() {
            int res = -1;
            if (!isEmpty()) {
                res = queue[(tail + queue.length - 1) % queue.length];
            }
            return res;
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % queue.length == head;
        }
    }

    /**
     * 循环双端队列
     */
    class MyCircularDeque {
        int[] queue;
        /**
         * 队头
         */
        int head = 0;
        /**
         * 队尾
         */
        int tail = 0;

        int length = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            queue = new int[k + 1];
            length = k + 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            boolean res = false;
            if (!isFull()) {
                //先后移再插入
                head = (length + head - 1) % length;
                queue[head] = value;

                res = true;
            }
            return res;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            boolean res = false;
            if (!isFull()) {
                queue[tail] = value;
                tail = (tail + 1) % length;
                res = true;

            }
            return res;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            boolean res = false;
            if (!isEmpty()) {
                head = (head + 1) % length;
                res = true;
            }
            return res;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            boolean res = false;
            if (!isEmpty()) {
                tail = (tail + length - 1) % length;
                res = true;
            }
            return res;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            int res = -1;
            if (!isEmpty()) {
                res = queue[head % length];
            }
            return res;

        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            int res = -1;
            if (!isEmpty()) {
                res = queue[(tail + length - 1) % length];
            }
            return res;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return head == tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return (tail + 1) % length == head;
        }
    }


    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        int rear = queue.Rear();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        boolean res = queue.deQueue();

    }


}
