package lab10;
import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值



    public MatrixUDG(char[] vexs, int[][] matrix) {
        
        int vlen = vexs.length;

        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];
    }


    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }



    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%10d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }


    public void prim(int start) {
        int num = mVexs.length;
        int index=0;
        char[] prims  = new char[num];
        int[] weights = new int[num];

        prims[index++] = mVexs[start];

        for (int i = 0; i < num; i++ )
            weights[i] = mMatrix[start][i];
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            if(start == i)
                continue;

            int j = 0;
            int k = 0;
            int min = INF;
            while (j < num) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            prims[index++] = mVexs[k];
            weights[k] = 0;
            for (j = 0 ; j < num; j++) {
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }

        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            int n = getPosition(prims[i]);
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n]<min)
                    min = mMatrix[m][n];
            }
            sum += min;
        }
        System.out.println("sum "+sum);
        for (int i = 0; i < index; i++)
            System.out.printf("%c ", prims[i]);
        System.out.printf("\n");
    }

  static   void printDrawCmd( int matrix[][]){
        String vs="ABCDEFG";
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int ma= matrix[i][j];
                if(ma==INF||ma==0){
                    continue;
                }
                System.out.println(vs.charAt(i)+ " "+vs.charAt(j)+" "+ma);
            }
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
         {   0,  12, INF, INF, INF,  16,  14},
         {  12,   0,  10, INF, INF,   7, INF},
         { INF,  10,   0,   3,   5,   6, INF},
         { INF, INF,   3,   0,   4, INF, INF},
         { INF, INF,   5,   4,   0,   2,   8},
         {  16,   7,   6, INF,   2,   0,   9},
         {  14, INF, INF, INF,   8,   9,   0}};


//        printDrawCmd(matrix);


        MatrixUDG pG;

        pG = new MatrixUDG(vexs, matrix);

        pG.prim(0);
    }
}
