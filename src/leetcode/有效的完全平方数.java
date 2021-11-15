package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 有效的完全平方数 {
    public static void main(String[] args) {

    }

    public boolean isPerfectSquare(int num) {
//        List<Integer> completeSquares = new ArrayList<>();
        List<Long> completeSquares = new ArrayList<>();
//        int maxNum = 9999999;
        int maxNum = 46340;
//        int maxCompleteSquare = 1 << 31 - 1;
        int maxCompleteSquare = Integer.MAX_VALUE;
//        for (int i = 1; i <  Integer.MAX_VALUE; i++) {
//        这个好慢
        long start = System.currentTimeMillis();
        for (int i = 1; i <= maxNum; i++) {
            int completeSquare = i * i;
//            long completeSquare=i*i;
//            if (completeSquare> maxCompleteSquare) break;
            completeSquares.add((long) completeSquare);
//            completeSquares.add(completeSquare);
        }
        long end = System.currentTimeMillis();
        long waste = end - start;
        System.out.println("waste  " + waste + " ms");
//        waste  5513 ms
//        乘法 很慢吗

        System.out.println("completeSquares add end");
//        https://www.cnblogs.com/sueyyyy/p/13502116.html
//        stream collect 最后10个
//        completeSquares.stream().skip().limit()
//        completeSquares.stream().reduce()
//        int num=0;
//        List<Integer> completeSquaresLast = new ArrayList<>();
        List<Long> completeSquaresLast = new ArrayList<>();
        int idx = completeSquares.size() - 1;
        for (int i = 0; i < 10; i++) {
            completeSquaresLast.add(completeSquares.get(idx));
            idx--;
        }
        System.out.println("completeSquaresLast");
        System.out.println(completeSquaresLast);
        return completeSquares.contains((long) num);
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        有效的完全平方数 有效的完全平方数 = new 有效的完全平方数();
        return 有效的完全平方数.isPerfectSquare(num);
    }

//    https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-mi-plir/
    public static void main(String[] args) {
       Solution solution = new Solution();
//        System.out.println(solution.isPerfectSquare(16));
//        System.out.println(solution.isPerfectSquare(14));
//        [1073741824, 1073676289, 1073610756, 1073545225, 1073479696, 1073414169, 1073348644, 1073283121, 1073217600, 1073152081]
//         2147395600
        System.out.println(solution.isPerfectSquare(2147395600));
//        System.out.println(Math.sqrt(2147395600));
//        46340.0
    }
}