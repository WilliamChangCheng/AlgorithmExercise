package dataStructure.analysis_of_Algorithms;

import java.math.BigInteger;

public class PowerOpreation {
    public static BigInteger pow (BigInteger x, int n) {
        if (n == 0)
            return new BigInteger(1 + "");
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x.multiply(x), n / 2).multiply(x);
        else
            return pow(x.multiply(x), n /2);
    }
    public static void main(String[] args) {
        BigInteger a = pow(new BigInteger("38"), 68);
    }
}
