package lab6;

import java.util.Iterator;

public class PrimeIterator<E> implements    java.util.Iterator<E>  {

    public static final int INITIAL_CAPACITY = 16;
//    private Object[] data = new Object[INITIAL_CAPACITY];
    private Object[] data ;
    int size=0;
    int maxNum;
    private int current = 0; // Current index
    @Override
//    public boolean hasNext() {
//        return current<size;
//    }
    public boolean hasNext() {
        return (int)data[current]<maxNum;
    }

    @Override
    public E next() {
        return (E)data[current++];
    }

//    public PrimeIterator(int size) {
//        this.size = size;
//        data=new Object[size];
//        putPrimes();
//    }

    public PrimeIterator(int maxNum) {
        this.maxNum = maxNum;
        size=maxNum;
        data=new Object[size];
        putPrimes();
    }

    void putPrimes(){
        int idx=0;
        for (int i = 2; idx<size&&i <777777777 ; i++) {
            if(isPrime(i)){
                data[idx++]=i;
            }
        }
    }

    public static boolean isPrime(int value) {
        int sqrt = (int) Math.sqrt(value);
        if (value <= 1) return false;
        if (value == 2) return true;
//        for (int i = 3; i <= sqrt; i += 2) {
        for (int i = 2; i <= sqrt; i ++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeIterator primeIterator=new PrimeIterator(8000);
//        primeIterator.forEachRemaining(System.out::println);
        primeIterator.forEachRemaining(o -> System.out.print(o+", "));
    }
}
