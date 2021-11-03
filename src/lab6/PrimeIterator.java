package lab6;

import java.util.Iterator;

public class PrimeIterator<E> implements java.util.Iterator<E> {

    public static final int INITIAL_CAPACITY = 16;
    //    private Object[] data = new Object[INITIAL_CAPACITY];
    private Object[] data;
    int size = 0;
    int maxNum;
    private int current = 0; // Current index

    @Override
//    public boolean hasNext() {
//        return current<size;
//    }
    public boolean hasNext() {
        return (int) data[current] < maxNum;
    }

    @Override
    public E next() {
        return (E) data[current++];
    }

//    public PrimeIterator(int size) {
//        this.size = size;
//        data=new Object[size];
//        putPrimes();
//    }

    public PrimeIterator(int maxNum) {
        this.maxNum = maxNum;
        size = maxNum;
        data = new Object[size];
        putPrimes();
    }

    void putPrimes() {
        int idx = 0;
        for (int i = 2; idx < size && i < 777777777; i++) {
            if (isPrime(i)) {
//            if (isPrime2(i)) {
                data[idx++] = i;
            }
        }
    }

    public static boolean isPrime(int value) {
        int sqrt = (int) Math.sqrt(value);
        if (value <= 1) return false;
        if (value == 2) return true;

        if (value % 2 == 0) return false;
        for (int i = 3; i <= sqrt; i += 2) {
//        for (int i = 2; i <= sqrt; i ++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime2(int value) {
        int sqrt = (int) Math.sqrt(value);
        if (value <= 1) return false;
        if (value == 2) return true;

//        if(value % 2 == 0) return false;
//        for (int i = 3; i <= sqrt; i += 2) {
        for (int i = 2; i <= sqrt; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        PrimeIterator primeIterator = new PrimeIterator(8000);
//        primeIterator.forEachRemaining(System.out::println);
//        System.out.println("primeIterator.size");
//        System.out.println(primeIterator.size);
        int cnt = 0;
        while (primeIterator.hasNext()) {
            cnt++;
            primeIterator.next();
        }
        System.out.println("cnt");
        System.out.println(cnt);
//        cnt
//        1007
//        奇数优化

//        cnt
//        1007
//        正确的
//        primeIterator.forEachRemaining(o -> System.out.print(o+", "));
    }
}
