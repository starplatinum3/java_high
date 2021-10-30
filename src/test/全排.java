package test;

import java.lang.reflect.Array;
import java.util.*;

public class 全排 {
	int n;
	int[] a;
	List<List<Integer>> res=new ArrayList<>();
	void dfs(int m) {
		if (m >= n) {
			System.out.println(Arrays.toString(a));
//			res.add();
//			new ArrayList<>();
			List<Integer> integers = new ArrayList<>();
			for (int i : a) {
				integers.add(i);
			}
//			List<int[]> ints = Arrays.asList(a);
//			res.add(Arrays.asList(a));
			res.add(integers);
			return;
		}
		for (int i = m; i < n; i++) {
			swap(i, m);
			dfs(m + 1);
			swap(i, m);
		}
	}

	void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		全排 全排 = new 全排();
		全排.n = 7;
//		n=
		全排.a = new int[全排.n];
		for (int i = 0; i < 全排.n; i++) {
			全排.a[i] = i;
		}
//		全排.dfs(7);
//		全排.dfs(5);
		全排.dfs(0);
//		从 0 开始全排列吗， idx
	}
}

class Solution {

	public List<List<Integer>> permuteUnique(int[] nums) {
		全排 全排 = new 全排();
//		全排.n = 7;
		全排.n = nums.length;
//		n=
		全排.a = new int[全排.n];
		//			全排.a[i] = i;
		System.arraycopy(nums, 0, 全排.a, 0, 全排.n);
//		全排.dfs(7);
//		全排.dfs(5);
		全排.dfs(0);

		List<List<Integer>> lists = 全排.res;
		Set<List<Integer>> set = new HashSet<>(lists);
		System.out.println(set);
		List<List<Integer>> ans = new ArrayList<>(set);
//		return 全排.res;
//		return 全排.res;
		return ans;
	}

	static  int funcTriangle(int i,int j){
//		return  (1+j-1)*(j-1)/2+i;
		return  (j)*(j-1)/2+i;
	}

	public static void main(String[] args) {
		int[] nums={1,1,2};
		Solution solution=new Solution();
		List<List<Integer>> lists = solution.permuteUnique(nums);
		Set<List<Integer>> set = new HashSet<>(lists);
//		System.out.println(set);
		System.out.println("lists");
		System.out.println(lists);

//		[1, 1, 2]
//[1, 2, 1]
//[1, 1, 2]
//[1, 2, 1]
//[2, 1, 1]
//[2, 1, 1]

	}

	void test1(){
		int funcTriangle1 = funcTriangle(2, 2);
		int funcTriangle2 = funcTriangle(3, 1);
		int funcTriangle3 = funcTriangle(1, 3);
		System.out.println("funcTriangle1");
		System.out.println(funcTriangle1);
		System.out.println("funcTriangle2");
		System.out.println(funcTriangle2);
		System.out.println("funcTriangle3");
		System.out.println(funcTriangle3);
//		funcTriangle1
//		3
//		funcTriangle2
//		3
//		funcTriangle3
//		4

	}
}