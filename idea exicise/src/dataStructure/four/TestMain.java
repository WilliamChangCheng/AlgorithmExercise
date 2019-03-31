package dataStructure.four;

public class TestMain {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(16);
        tree.insert(15);
        tree.insert(14);
        tree.insert(13);
        tree.insert(12);
        tree.insert(11);
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.checkBalance();
    }
}
