package leetcode;

public class Easy_190_ReverseBits {
    public static void main(String[] args) {
//        System.out.println(4 << 1); //8
//        System.out.println(4 >> 1); //2
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >> 1;
        }
        return result;
    }

    public int reverseBits2(int n) {
        long longN = Integer.toUnsignedLong(n);
        long result = 0;
        for (int i = 0; i < 32; i++) {
            long mod = longN % 2;
            longN = longN >> 1;
            result = (result << 1) + mod;
        }
        return (int) result;
    }

}
