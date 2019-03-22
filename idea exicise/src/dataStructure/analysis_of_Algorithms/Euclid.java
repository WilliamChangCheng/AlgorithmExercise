package dataStructure.analysis_of_Algorithms;
//求两个数的最大公因数
public class Euclid {
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }
    public static void main(String[] args) {
        long a = gcd(50,75);
    }
}
