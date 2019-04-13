package leetcode.array;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int count = 0, max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0)
                count++;
            else if (count != 0) {
                int start = i - count;
                if (start == 0) {
                    max = Math.max(max, count);
                }
                else {
                    int mid = (i - start) / 2 + start;
                    //start是第一个零的位置，i是1的位置，第二个所以需要加一
                    int min = Math.min(i - mid, mid - start + 1);
                    max = Math.max(min, max);

                }
                count = 0;

            }
        }
        if (count != 0) {
            max = Math.max(max, count);
        }
        return max;
    }

}
