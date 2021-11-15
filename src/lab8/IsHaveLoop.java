package lab8;

//https://blog.csdn.net/weixin_43312097/article/details/105317541

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:判断无向图是否有环 深度优先遍历
 * 需要保存父节点
 * @Create 2020-04-03 21:04
 * @Email:1173748742@qq.com
 */
public class IsHaveLoop {
    public static void main(String[] args) {
        IsHaveLoop isHaveLoop = new IsHaveLoop();
        int[][] graph = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {2, 4}};
        int n = 5;
        boolean haveLoop = isHaveLoop.isHaveLoop(graph, n);
        System.out.println(haveLoop);
    }
    /**
     * @param graph 图的连接边
     * @param n     图的节点个数
     * @return 是否存在环
     */
    public boolean isHaveLoop(int[][] graph, int n) {
        //这段代码可要可不要，可以提前判断结果
//        if (graph.length >= n) {//当边数大于节点的个数时，必定存在环 自己可以画图推导
//            return true;
//        }
        //习惯上转换成临接表的形式
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edg : graph) {
            int node1 = edg[0];
            int node2 = edg[1];
//            这里面是 横纵坐标
            if (adj[node1] == null) {
                adj[node1] = new ArrayList<>();
            }
            if (adj[node2] == null) {
                adj[node2] = new ArrayList<>();
            }
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];//定义一个节点状态数组  判断是否访问过
        int[] a = {0};
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {//如果没有进行访问  则进行深度优先搜索回溯
                dfsCycle(adj, i, -1, visited, a);//引用传递  函数内部修改值后退出函数可见
//                System.out.println(a[0]);
                if (a[0] == 1) {//只要有一次i循环时存在环路那就直接提前返回，说明存在环
                    return true;
                }
            }
        }
        return a[0] == 1;
    }


    /**
     * @param adj     图的临接表
     * @param current 当前节点
     * @param parent  父节点
     * @param visited 判断是否访问
     * @param flag    是否存在环
     */
    private void dfsCycle(List<Integer>[] adj, int current, int parent, boolean[] visited, int[] flag) {
        visited[current] = true;//首先 访问当前节点   并进行标记
        List<Integer> list = adj[current];  //获取到当前节点能够到达的所有节点
//        他的所有邻居
        for (Integer can : list) {
            if (visited[can] == false) {//如果节点没有被访问过
                dfsCycle(adj, can, current, visited, flag);//当前节点就是父节点，循环的节点就是子节点
            } else if (can != parent) {// 在节点被访问过的情况下 如果该节点不等于父节点  ，说明有环
                flag[0] = 1;
            }
            //循环节点等于父节点的情况直接跳过，不用处理
        }
    }
}
