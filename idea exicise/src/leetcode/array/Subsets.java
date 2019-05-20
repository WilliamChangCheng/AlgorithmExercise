package leetcode.array;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
public class Subsets {
    /**
     * 用hashmap.记录位置，list存进去后，克隆一个，然后顺序添加
     * 自己想的方法，先添加长度为1的，比如nums[1，2，3]，list中有[1][2][3]。然后遍历list集合，[1]克隆一份为temp，然后从1开始遍历nums数组，
     * 然后temp.add（2），nums还没有循环完，再克隆[1]为temp，temp.add（3）。list集合指针前移为[2]，克隆后操作为[2,3]。
     * list指针前移为[1,2]，克隆操作后为[1,2,3]；指针前移，直到指针前移2的nums.length次方减去数组长度（因为长度为1的先加上）再减去1（空集的情况），最后加上空集；
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        //存储nums里面的值
        Map<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        //把单数存进去，并建立索引
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            res.add(temp);
        }

        //region 不能用迭代器，因为向res会改变，迭代器会报错，所以不能用
//        for (Iterator<List<Integer>> iterator = res.iterator(); iterator.hasNext(); ) {
//            List<Integer> next = iterator.next();
//            //找到当前list最后一个元素的index，从此开始循环，后面的一个个的加
//            for (int i = next.get(next.size() - 1) + 1; i < nums.length; i++) {
//                //必须用深拷贝，因为，你复制的是list里的东西，是个对象，不是基本类型，是占内存堆的，所以简单的遍历是不行的
//                List<Integer> temp = deepCopy(next);
//                temp.add(nums[i]);
//            }
//        }
//endregion

        //a < 2 << (nums.length - 2) - 1,一个数组全遍历分组有2的nums.length次方，是1左移nums.length次
        int cou = 1 << nums.length;
        for (int a = 0; a < cou - nums.length - 1; a++) {
            //确定list中的元素是不是nums的最后一个元素，如果是，就下一个循环
            List<Integer> tl = res.get(a);
            int lastInd = hm.get(tl.get(tl.size() - 1));
            //找到当前list最后一个元素的index，从此开始循环，后面的一个个的加
            for (int i = lastInd + 1; i < nums.length; i++) {
                //必须用深拷贝，因为，你复制的是list里的东西，是个对象，不是基本类型，是占内存堆的，所以简单的遍历是不行的
                //先用浅拷贝也能实现目的，但是草鸡慢
                List<Integer> temp = new ArrayList<>(tl);
                temp.add(nums[i]);
                res.add(temp);
            }

        }
        res.add(new ArrayList<>());
        return res;
    }

    /**
     * 深拷贝List
     *
     * @param src
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> deepCopy(List<T> src) {
        List<T> dest = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);

            dest = (List<T>) in.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return dest;
    }

    //region 递归法
    /**
     * 递归过程
     *                          []
     *                    /          \
     *                   /            \
     *                  /              \
     *               [1]                []
     *            /       \           /    \
     *           /         \         /      \
     *        [1 2]       [1]       [2]     []
     *       /     \     /   \     /   \    / \
     *   [1 2 3] [1 2] [1 3] [1] [2 3] [2] [3] []
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i<nums.length; i++) {
            temp.add(nums[i]);
            backtracking(res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
    //endregion

    /**
     * 循环法
     * 对于题目中给的例子 [1,2,3] 来说，
     * 最开始是空集，那么我们现在要处理1，就在空集上加1，为 [1]，现在我们有两个自己 [] 和 [1]，
     * 下面我们来处理2，我们在之前的子集基础上，每个都加个2，可以分别得到 [2]，[1, 2]，那么现在所有的子集合为 [], [1], [2], [1, 2]，
     * 同理处理3的情况可得 [3], [1, 3], [2, 3], [1, 2, 3],
     * 再加上之前的子集就是所有的子集合了
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer>list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }



}
