package lab8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UnweightedGraphFindCycle extends UnweightedGraph {

    public UnweightedGraphFindCycle(List list, int numberOfVertices) {
        super(list, numberOfVertices);
    }

    public static void main(String[] args) {
//        int[][] edges=new int[5][5];
//        int[][] edges=new int[4][2];
//        edges[][]
//        Edge edge=new Edge(0,0);
//        Edge edge=new Edge(0,1);
        List<Edge>edges1=new ArrayList<>();
//        edges1.add(new Edge(0,0));
//        edges1.add(new Edge(0,1));
//        edges1.add(new Edge(1,0));
//        edges1.add(new Edge(1,1));

//        edges1.add(new Edge(0,1));
//        edges1.add(new Edge(1,4));
//        edges1.add(new Edge(4,3));
//        edges1.add(new Edge(3,0));

        edges1.add(new Edge(0,1));
        edges1.add(new Edge(1,2));


//        UnweightedGraphFindCycle unweightedGraphFindCycle=new UnweightedGraphFindCycle();
//        UnweightedGraphFindCycle unweightedGraphFindCycle=new UnweightedGraphFindCycle(edges1,edges1.size());
        UnweightedGraphFindCycle unweightedGraphFindCycle=new UnweightedGraphFindCycle(edges1,6);
//        unweightedGraphFindCycle.
//        List<Integer> aCycle = unweightedGraphFindCycle.getACycle(0);
        List<Integer> aCycle = unweightedGraphFindCycle.getACycle(2);
        System.out.println("aCycle");
        System.out.println(aCycle);
//        aCycle
//                [0, 1, 4, 3]

//        aCycle
//                [2]

//        aCycle
//        null
    }
    public List<Integer> getACycle(int u){
//        https://blog.csdn.net/weixin_43312097/article/details/105317541
//        vertices.add();
//        vertices.get()
        int size = vertices.size();
        boolean[] visited = new boolean[size];//定义一个节点状态数组  判断是否访问过
        int[] a = {0};
        List<Integer>[] adj=new ArrayList[size];
        List<Integer>circle=new ArrayList<>();
//        circle.add(u);
//        vertices.
//        Object o = neighbors.get(u);
        dfsCycle(adj, u, -1, visited, a,circle);//引用传递  函数内部修改值后退出函数可见

//        for (int i = 0; i < size; i++) {
////            他的所有点 就是 0 -- n吗
////            是值还是下标
////            怎么从u 开始
//            if (visited[i] == false) {//如果没有进行访问  则进行深度优先搜索回溯
//                dfsCycle(adj, i, -1, visited, a,circle);//引用传递  函数内部修改值后退出函数可见
////                System.out.println(a[0]);
//                if (a[0] == 1) {//只要有一次i循环时存在环路那就直接提前返回，说明存在环
//                    return true;
//                }
//            }
//        }
//        System.out.println("circle");
//        System.out.println(circle);
        if(circle.size()==1){
            return null;
        }
        return circle;
//        return a[0] == 1;
    }

    /**
     * @param adj     图的临接表
     * @param current 当前节点
     * @param parent  父节点
     * @param visited 判断是否访问
     * @param flag    是否存在环
     */
    private void dfsCycle(List<Integer>[] adj, int current,
                          int parent, boolean[] visited,
                          int[] flag, List<Integer>circle) {
        visited[current] = true;//首先 访问当前节点   并进行标记
//        List<Integer> list = adj[current];  //获取到当前节点能够到达的所有节点
//        Object o = neighbors.get(current);
//        他的所有邻居
        circle.add(current);
        List<Integer> neighbors = getNeighbors(current);
        for (Integer can : neighbors) {
//            HashSet

            if (visited[can] == false) {//如果节点没有被访问过
//                dfsCycle(adj, can, current, visited, flag);//当前节点就是父节点，循环的节点就是子节点
                dfsCycle(adj, can, current, visited, flag,circle);//当前节点就是父节点，循环的节点就是子节点
            } else if (can != parent) {// 在节点被访问过的情况下 如果该节点不等于父节点  ，说明有环
                flag[0] = 1;
            }
            //循环节点等于父节点的情况直接跳过，不用处理
        }
    }
}
