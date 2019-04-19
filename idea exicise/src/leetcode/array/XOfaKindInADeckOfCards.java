package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class XOfaKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int val = 0;

        for (Integer value : map.values()) {
            val = gcd(value, val);
        }
        return val > 1;
    }
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
