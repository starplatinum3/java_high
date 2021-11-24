package lab10;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    static class Node {
        int u, v;
        int id, w;

        @Override
        public String toString() {
            return "Node{" +
                    "u=" + u +
                    ", v=" + v +
                    ", id=" + id +
                    ", w=" + w +
                    '}';
        }

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    void init() {
//		f=new int[111111];
        f = new int[n + 1];
        for (int i = 0; i < f.length; i++) {
//		for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        kruskal.n = 6;
        kruskal.init();

        List<Node> list = new ArrayList<>();
        list.add(new Node(1, 2, 1));
        list.add(new Node(2, 4, 2));
        list.add(new Node(3, 4, 3));
        list.add(new Node(6, 4, 4));
        list.add(new Node(3, 5, 5));
        list.add(new Node(6, 5, 6));
        kruskal.krus(list);
        System.out.println("kruskal.ans");
        System.out.println(kruskal.ans);

//		node
//		Node{u=1, v=2, id=0, w=1}
//		node
//		Node{u=2, v=4, id=0, w=2}
//		node
//		Node{u=3, v=4, id=0, w=3}
//		node
//		Node{u=6, v=4, id=0, w=4}
//		node
//		Node{u=3, v=5, id=0, w=5}
//		kruskal.ans
//		15

	}

    int n;
    int ans = 0;
    int[] f;

    int find(int x) {
        if (x == f[x])
            return x;
        return f[x] = find(f[x]);
    }

    //	void krus(List<Node> list ) {
//
//	}
    void krus(List<Node> list) {
//		List<Node> list = new ArrayList<>();
        list.sort((o1, o2) -> {
            return o1.w - o2.w;
        });
        int cnt = 0;
        for (Node node : list) {
            int fx = find(node.u);
            int fy = find(node.v);
            if (fx == fy)
                continue;
            f[fx] = fy;
            cnt++;
            System.out.println("node");
            System.out.println(node);
            ans += node.w;
            if (cnt == n - 1)
                break;

        }

    }

//	void krus() {
//		List<Node>list=new ArrayList<>();
//		list.sort((o1,o2)->{
//			return o1.w-o2.w;
//
//		});
//		int cnt=0;
//		for (int i = 0; i <list.size(); i++) {
//			int fx=find(list.get(i).u);
//			int fy=find(list.get(i).v);
//			if(fx==fy)continue;
//			cnt++;
//			ans+=list.get(i).w;
//			if(cnt==n-1)break;
//
//		}
//
//
//	}
}
