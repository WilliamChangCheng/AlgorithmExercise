package leetcode.array;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ind = 0;
        int count = 0;
        while (ind < flowerbed.length) {
            if (flowerbed[ind] == 0 && (ind == 0 || flowerbed[ind - 1] == 0) && (ind == flowerbed.length - 1 || flowerbed[ind + 1] == 0)) {
                //也可以不用先种上，记下上一个种下的位置也可以
                flowerbed[ind] = 1;
                count++;
            }
            ind++;
        }
        return count >= n;


    }
}
