package lab4;

import java.util.Iterator;
import java.util.Scanner;

//import com.sun.java_cup.internal.runtime.Scanner;

public class DiZeng {
  public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	String string=scanner.nextLine();
	int maxx=0;
	int st=0;
	for(int i=0;i<string.length();i++) {
		int calStrLen=calStr(i,string);
	   if(maxx<calStrLen) {
		   maxx=calStrLen;
		   st=i;
	   }
	}
//	复杂度 n^2
	System.out.println(string.substring(st,st+maxx));
}
  
  static int  calStr(int st,String string) {
	  int len;
	  for(int i=st+1;i<string.length();i++) {
		  
		  if(string.charAt(i)<=string.charAt(i-1)) {
			  len=i-st;
			  return len;
//			  break;
		  }
	  }
	  return string.length()-st;
  }
}
