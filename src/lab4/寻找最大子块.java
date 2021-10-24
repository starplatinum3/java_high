package lab4;

import java.util.Scanner;

//http://liveexample.pearsoncmg.com/dsanimation/LargestBlock.html
//根据这里的 js 代码，翻译的java 代码
//不知道怎么扩展到 长方形
//是正方形 不是长方形
public class 寻找最大子块 {
//    int size;
//    文档：14 5.note
//    链接：http://note.youdao.com/noteshare?id=2676afa8be4950d1b91a165389504a68&sub=4E79046F83D543DCA28325226EED2D37
    public static void main(String[] args) {
        int [][]mat=new int[10][10];
        int size=10;
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                mat[i][j]=  scanner.nextInt();
            }
        }
        int[] LargestBlockRes= findLargestBlock(mat,size);
        int maxOfx=LargestBlockRes[0];
        int maxOfy=LargestBlockRes[1];
        int max=LargestBlockRes[2];
        int len=LargestBlockRes[3];
        int maxOfxRight=0;
        int maxOfyRight=0;

//        for (int i = maxOfx; i <size ; i++) {
//            if(mat[i][maxOfy]==0){
//                System.out.println("寻找maxOfxRight");
//                System.out.println("i: "+i);
//                maxOfxRight=i-1;
//                break;
//            }
//        }
//
//        for (int i = maxOfy; i <size ; i++) {
//            if(mat[maxOfx][i]==0){
//                System.out.println("寻找maxOfyRight");
//                System.out.println("i: "+i);
//                maxOfyRight=i-1;
//                break;
//            }
//        }


//        System.out.println();
//        ，输出左上角和右下角坐标。
//        System.out.println(String.format("(%d,%d), (%d,%d)",maxOfx,maxOfy,maxOfxRight,maxOfyRight ));
//        System.out.println(String.format("(%d,%d)(%d,%d)",maxOfx,maxOfy,maxOfxRight,maxOfyRight ));
        System.out.println(String.format("(%d,%d)(%d,%d)",maxOfx,maxOfy,maxOfx+len-1,maxOfy+len-1 ));
//        count[maxOfx][maxOfy]
//        4
    }

    void findRightPoint(int leftX,int leftY){
        for (int i = 1; i <9 ; i++) {

        }
    }

    void findOfSize(int size,int leftX,int leftY){
        for (int i = leftX; i < 10; i++) {
            for (int j = leftY; j <10 ; j++) {

            }
        }
    }
  static   int[] findLargestBlock(int[][] m,int size) {
        int max = 0;
        int maxOfx = 0;
        int maxOfy = 0;

//        var count = new Array(size);
        int[][] count = new int[100][100];
//        for (int i = 0; i < size; i++) {
//            count[i] = new Array(size);
//        }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                count[i][j] = 0;

        for (int i = m.length - 1; i >= 0; i--)
            for (int j = m[i].length - 1; j >= 0; j--)
                if (m[i][j] == 1) {
                    if (i == m.length - 1 || j == m[i].length - 1) {
                        count[i][j] = 1;
                        // 最后一个
                    }

                    // We reduce the overall complexity to O(n^2) by using this clever approach
                    // 通过使用这种巧妙的方法，我们将总体复杂性降低到O（n^2）
                    if (i < m.length - 1 && j < m[i].length - 1) {
                        // 不是最后一行 不是最后一列
                        count[i][j] = 1 + Math
                                .min(Math.min(count[i + 1][j + 1], count[i + 1][j]),
                                        count[i][j + 1]);
//                        他往 正方形的另外三个方向延伸
//                        就是说 如果全是1 就可以加上1 了，如有任意一个不是1，那就是不能加上

                        //   往右边一格 往 下面一个 ，如果他自己和他旁边的是1
                        // 那就是1 ，在加上他下面的1 ，如果三个里有一个是0
                        // 那就是0
                        // +1 是因为他本身是1 吗 ,应该是吧 因为 if (m[i][j] == 1) {
                    }

                    if (count[i][j] > max) {
                        max = count[i][j];
                        maxOfx = i;
                        maxOfy = j;
                    }
                }

//        int[] result = new int[3];
        int[] result = new int[4];
        result[0] = maxOfx;
        result[1] = maxOfy;
        result[2] = max;
        result[3] = count[maxOfx][maxOfy];

//      System.out.println("count[maxOfx][maxOfy]");
//      System.out.println(count[maxOfx][maxOfy]);
        return result;
    }

}

//class Main{
//	public static void main(String[] args) {
//		寻找最大子块.main(args);
//	}
//}