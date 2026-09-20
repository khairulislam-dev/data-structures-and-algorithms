public class BitManipulation {
    // bitwise and operation(&)
    public static void bitwiseAndOP(int a, int b) {
        int result = a & b;
        System.out.printf("BITWISE AND: %d & %d = %d\n", a, b, result);
    }

    // bitwise or operation (|)
    public static void bitwiseOrOperation(int a, int b) {
        int result = a | b;
        System.out.printf("BITWISE  OR: %d | %d = %d\n", a, b, result);
    }

    // bitwise xor operation (^)
    public static void bitwiseXOR(int a, int b) {
        System.out.printf("BITWISE XOR: %d ^ %d = %d\n", a, b, a ^ b);
    }

    // bitwise not operation (~)
    public static void bitwiseNOT(int a) {
        System.out.println("BITWISE NOT: ~" + a + " = " + ~a);
    }

    // bitwise left shift operation (<<)
    public static void bitwiseLeftShift2(int a) {
        int r = a << 2;
        System.out.println("BITWISE LEFT SHIFT: " + a + " << 2 = " + r);
    }

    // bitwise right shift operation (>>)
    public static void bitwiseRightShift2(int a) {
        int r = a >> 2;
        System.out.println("BITWISE RIGHT SHIFT: " + a + " >> 2 = " + r);
    }

    // number odd or even check throw bin and operation give (0 even) or (1 Odd)
    public static void evenOddCheck(int n) {
        int r = n & 1;
        if (r == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    // get ith bit
    public static void getIthBit(int a, int n) {
        int r = a >> n;
        r = r & 1;
        System.out.println(a + " ith bit: " + r);
    }

    // set ith bit
    public static void setIthBit(int a, int i, int bit) {
        int r = a | (bit << i);
        System.out.printf("set %d bit in %d: %d\n", i, a, r);
    }

    // clear ith bit
    public static void clearIthBit(int a, int i) {
        int bitmask = 1 << i;
        int r = a & (~bitmask);
        System.out.println("Clear ith bit: " + r);
    }

    // update ith bit
    public static void updateIthBit(int a, int i, int bit) {
        a = a & ~(1 << i);
        a = a | (bit << i);
        System.out.println("update ith bit: " + a);
    }

    public static void clearLastIthBit(int n, int i) {
        int bitmask = (~0) << i;
        n = n & bitmask;
        System.out.println("clear last ith bit: " + n);
    }

    public static void clearRangeOfBit(int n, int i, int j) {
        int a = (~0) << j + 1;
        int b = (1 << i) - 1;
        int bitmask = a | b;
        n = n & bitmask;
        System.out.println("clear range of bit: " + n);
    }

    public static void isPowerOf2(int n) {
        n = (n & (n - 1));

        if (n == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            int t = n & 1 << 0;
            if (t == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println("total set of bits: " + count);
    }

    public static void fastExpo(int a, int n) {
        int answer = 1;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                answer = answer * a;
            }
            a = a * a;
            n = n >> 1;
        }
        System.out.println(answer);
    }

    // question 01 ---------
    public static void checkXORSameValue(int x) {
        System.out.println(x ^ x);
    }

    // question 02 ------------
    public static void swapTwoNum(int a, int b) {
        // without third variable
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    // question 03 ---------
    public static void addOneAnyInteger(int n) {
        n = n << 1;
        n = n ^ (1 << 1);
        System.out.println(n);
    }

    public static void upperToLowerCase() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println((char) (ch | ' '));
        }
    }

    public static void main(String[] args) {
        // bitwiseAndOP(3, 7);
        // bitwiseOrOperation(3, 7);
        // bitwiseXOR(3, 7);
        // bitwiseNOT(5);
        // bitwiseLeftShift2(3);
        // bitwiseRightShift2(5);
        // evenOddCheck(10);
        // getIthBit(2, 1);
        // setIthBit(5, 2, 1);
        // clearIthBit(5, 0);
        // updateIthBit(10, 2,1);
        // clearLastIthBit(15, 3);
        // clearRangeOfBit(127, 3, 4);
        // isPowerOf2(16);
        // countSetBits(32);
        // fastExpo(2, 8);

        // question 01 ------
        // checkXORSameValue(4);
        // question 02-----
        // swapTwoNum(3, 9);
        // question 03 --------
        // addOneAnyInteger(4);
        // int x = 6;
        // System.out.println(x + " + " + 1 + " is " + -~x);
        // x = -4;
        // System.out.println(x + " + " + 1 + " is " + -~x);
        // x = 0;
        // System.out.println(x + " + " + 1 + " is " + -~x);
        System.out.println(-~5);
        // question 04 ---------
        // upperToLowerCase();
    }
}
