package lab4;

import java.util.Scanner;

public class SameNumLongest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String string=scanner.nextLine();
		int nowNum = 0;
		int nowNumLen = 0;
		int maxLenNum = 0;
		int maxLen = 0;
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if (num == 0)
				break;
			if (num == nowNum) {
				nowNumLen++;
			} else {
				nowNum=num;
				nowNumLen = 1;
			}
			if (nowNumLen > maxLen) {
				maxLenNum = nowNum;
				maxLen = nowNumLen;
			}
		}
		System.out.println("maxLenNum");
		System.out.println(maxLenNum);
		System.out.println("maxLen");
		System.out.println(maxLen);
	}
}
