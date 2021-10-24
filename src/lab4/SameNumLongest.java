package lab4;

import java.util.Scanner;
//文档：2 4 4 8 8 8 8 2 4 4 0.note
//		链接：http://note.youdao.com/noteshare?id=991b679b42f6a67e0bd0dfe96ad4199e&sub=C96104BA6AA14766B82A2598BAE1D05F
public class SameNumLongest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String string=scanner.nextLine();
		int nowNum = 0;
		int nowNumLen = 0;
		int maxLenNum = 0;
		int maxLen = 0;
		int idx=0;
		int nowNumIdx=0;
		int i=0;
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if (num == 0)
				break;
			if (num == nowNum) {
				nowNumLen++;
			} else {
				nowNum=num;
				nowNumLen = 1;
				nowNumIdx=i;
			}
			if (nowNumLen > maxLen) {
				maxLenNum = nowNum;
				maxLen = nowNumLen;
				idx=nowNumIdx;
			}
			i++;
		}
//		System.out.println("maxLenNum");
//		System.out.println(maxLenNum);
//		System.out.println("maxLen");
//		System.out.println(maxLen);

//		index 3 with 4 values8 8 2 4 4 0
////		maxLenNum
////		8
////		maxLen
////		4
////		index 3 with 8 values of 4 of 8
//		System.out.println(String.format("index %d with %d values of %d",idx,maxLenNum,maxLen ));
		System.out.println(String.format("index %d with %d values of %d",idx,maxLen,maxLenNum ));
//		2 4 4 8 8
	}
}

//class Main{
//	public static void main(String[] args) {
//		SameNumLongest.main(args);
//	}
//}
