package leetcode.array;

public class CapacityToShipPackagesWithinDDays {

    //region 自己想的
    /**
     * 自己想的，速度特别慢，用递归实现问题分解方法
     * @param weights
     * @param D
     * @return
     */
    public static int shipWithinDays(int[] weights, int D) {
        if (D == 1) {
            int max = 0;
            for (int i = 0; i < weights.length; i++) {
                max += weights[i];
            }
            return max;
        }
        int minWeight = Integer.MAX_VALUE;
        //循环到最后剩下D-1个
        int first = 0;
        for (int i = 0; i <= weights.length - D; i++) {
            first += weights[i];

            int a = ship(weights, i + 1, D - 1);
            minWeight = Math.min(minWeight, Math.max(first, a));
        }
        return minWeight;
    }

    public static int ship(int[] weight, int start, int d) {
        if (d == 1) {
            int max = 0;
            for (int i = start; i < weight.length; i++) {
                max += weight[i];
            }
            return max;
        }
        int minWeight = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int first = 0;
        for (int i = start; i <= weight.length - d; i++) {
            first += weight[i];
            int a = ship(weight, i + 1, d -1);
            max = Math.max(first, a);
            minWeight = Math.min(minWeight, max);
        }
        return minWeight;

    }
    //endregion

    /**
     * 二分查找，根据题意，结果一定落在[max(weights), sum(weights）]这个区间之间，
     * 因为左端点对应每天一条船，右端点对应只有一条超级大船。
     * 然后利用二分法，每一次循环模拟运货的过程，然后根据需要的天数与 输入 D 的关系来调整区间左右端点。
     * @param weights
     * @param D
     * @return
     */
    public static int shipWithinDays1(int[] weights, int D) {

        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        while (max < sum) {
            //mid为当前运送的容量
            int mid = (sum + max) / 2;
            //temp表示当天这条船承载的容量，day表示天数
            int temp = 0;
            int day = 1;
            for (int weight : weights) {
                temp += weight;
                if (temp > mid) {
                    day += 1;
                    temp = weight;
                }

            }
            if (day > D) {
                max = mid + 1;
            } else if (day <= D) {
                sum = mid;
            }
        }
        return max;

    }


    public static void main(String[] args) {
        int a = shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 1);

    }
}
