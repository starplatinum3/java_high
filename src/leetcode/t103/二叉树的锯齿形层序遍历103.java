package leetcode.t103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的锯齿形层序遍历103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        Queue<TreeNode>queue=new LinkedList<>();
        Queue<Node>queue=new LinkedList<>();
        Node node=new Node();
        node.setLev(0);
        node.setNode(root);
//        queue.add(root);
        queue.add(node);
        List<List<Integer>>lists=new ArrayList<>();
//        int lev=0;
        while (!queue.isEmpty()){
//            TreeNode poll = queue.poll();
            Node poll = queue.poll();
            int lev=poll.getLev();
            if(lev%2==0){
//                一下子就只有两个
//                他的 lev 是不是一定要 设置的啊
                if(poll.getNode().left!=null){
//                    poll.getNode().left.
                    queue.add(poll.left);
                }
                if(poll.left!=null){
                    poll.left.setLev(lev+1);
//                    poll.getNode().left.
                    queue.add(poll.left);
                }

                if(poll.right!=null){
                    queue.add(poll.right);
                }

//                queue.add(poll.right);
            }else{
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
            }
            lev++;
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Node{
    TreeNode node;
    int lev;
    Node left;
    Node right;

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        Queue<TreeNode>queue=new LinkedList<>();
        Queue<Node>queue=new LinkedList<>();
        Node node=new Node();
        node.setLev(0);
        node.setNode(root);
//        queue.add(root);
        queue.add(node);
        List<List<Integer>>lists=new ArrayList<>();
        int lev=0;
        while (!queue.isEmpty()){
//            TreeNode poll = queue.poll();
            Node poll = queue.poll();
            if(lev%2==0){
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }

//                queue.add(poll.right);
            }else{
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                if(poll.left!=null){
                    queue.add(poll.left);
                }
            }
            lev++;
        }

        return lists;
    }


}