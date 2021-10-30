package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//8_3
public class MathUtil {

   public static boolean isPrime(int value) {
        int sqrt = (int) Math.sqrt(value);
        if (value <= 1) return false;
        if (value == 2) return true;
        for (int i = 3; i <= sqrt; i += 2) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("Enter integers(input ends with 0):");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            Integer intNum = scanner.nextInt();
            if (intNum == 0) break;
            list.add(intNum);

        }
        scanner.close();
        System.out.println("The mininum number is " + min(list));
    }

    public static Integer min(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) return null;
        Integer minNum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (minNum > list.get(i)) {
                minNum = list.get(i);
            }
        }
        return minNum;
    }
}
