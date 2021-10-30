package lab6;

public class FirstNPrime {


    static boolean isPrime(int value) {
        int sqrt = (int) Math.sqrt(value);
        if (value <= 1) return false;
        if (value == 2) return true;
        for (int i = 3; i <= sqrt; i += 2) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        58, 53, 52, 47, 46, 44, 43, 41, 38, 37, 34, 32, 31, 29, 28, 26, 23, 22,
//        20, 19, 17, 16, 14, 13, 11, 10, 8, 7, 6, 5, 4, 3, 2,
        int n = 33;
        int num = 0;
        GenericStack stack = new GenericStack<Integer>();
        for (int i = 2; i < 1100000; i++) {
            if (isPrime(i)) {
                stack.push(i);
                num++;
                if (num >= n) {
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+", ");
        }
    }
}
