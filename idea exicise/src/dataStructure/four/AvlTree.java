package dataStructure.four;

public class AvlTree<T extends Comparable<? super T>> {

    private AvlNode<T> root;
    private static final int ALLOED_IMBALANCE = 1;
    public AvlTree(){ root = null;}
//    public AvlTree(T ele) {
//        this(ele, null, null);
//    }
//    public AvlTree(T ele, AvlTree<T> l, AvlTree<T> r) {
//        element = ele;
//        left = l;
//        right = r;
//        height = 0;
//    }

    /**
     * 插入节点
     * @param x
     */
    public void insert(T x) { root = insert(x, root);}

    /**
     * 求所给节点的高度
     * @param ele
     * @return
     */
    private int height(AvlNode<T> ele) {
        return ele == null ? -1 : ele.height;
    }

    /**
     * 左单旋
     * @param k1 子树根
     * @return 新的子树根
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k2.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    /**
     * 右单旋
     * @param k2 子树根
     * @return 新的子树根
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * 双旋转先左旋后右旋
     * @param k3
     * @return
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 双旋转先右后左
     * @param k1
     * @return
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }


    /**
     * 对树进行平衡操作
     * @param t
     * @return
     */
    private AvlNode<T> balance (AvlNode<T> t) {
        if (t == null) return t;
        //左子树高于右子树多于1的时候，有两种情况：一种是左子树长，用右单旋转（旋转左子树）；一种是右子树长，用左双旋转，先左旋转，后右旋转（先旋转右子树,后右子树）
        if (height(t.left) - height(t.right) > ALLOED_IMBALANCE) {
            //左子树长，用右单旋转（旋转左子树）
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            //右子树长，用左双旋转，先左旋转，后右旋转（先旋转右子树,后右子树）
            else
                t = doubleWithLeftChild(t);
        }
        //右子树高于左子树时，分两种情况处理：一是左子树长，用先右双旋转；一是右子树长，用左单旋转
        else if (height(t.right) - height(t.left) > ALLOED_IMBALANCE) {
            //左子树长，先右双旋转
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);

        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return balance(t);
    }
//    public AvlNode<T> add(AvlNode<T> t) {
//        if (element == null) {
//            element = t.element;
//            left = t.left;
//            right = t.right;
//        } else {
//            insert(element, t);
//        }
//        return t;
//    }
//    public AvlTree<T> add(T e) {
//        AvlTree<T> t = new AvlTree<>(e);
//        return add(t);
//    }

    /**
     * 检查是否是平衡的
     */
    public void checkBalance() {checkBalance(root);}

    private int checkBalance(AvlNode<T> t) {
        if (t == null)
            return -1;
        else {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1 ||
            height(t.left) != hl || height(t.right) != hr)
                System.out.println("OOPS");
        }
        return height(t);
    }


    private class AvlNode<T> {
        AvlNode (T ele) {
            this(ele, null, null);
        }
        AvlNode (T ele, AvlNode<T> l, AvlNode<T> r) {
            element = ele;
            left = l;
            right = r;
            height = 0;
        }
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }


}
