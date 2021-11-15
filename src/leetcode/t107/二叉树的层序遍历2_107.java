package leetcode.t107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历2_107 {
    public static void main(String[] args) {
        二叉树的层序遍历2_107 二叉树的层序遍历2_107=new 二叉树的层序遍历2_107();
//        TreeNode root=new TreeNode();
//        root.val=3;
//        root.left=new TreeNode(9);
//        root.right=new TreeNode(20);
//        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(7);
//        List<List<Integer>> lists = 二叉树的层序遍历2_107.levelOrderBottom(root);
//        System.out.println("lists");
//        System.out.println(lists);

        TreeNode root=null;

        List<List<Integer>> lists = 二叉树的层序遍历2_107.levelOrderBottom(root);
        System.out.println("lists");
        System.out.println(lists);
    }

    void test1(){
        二叉树的层序遍历2_107 二叉树的层序遍历2_107=new 二叉树的层序遍历2_107();
        TreeNode root=new TreeNode();
        root.val=3;
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> lists = 二叉树的层序遍历2_107.levelOrderBottom(root);
        System.out.println("lists");
        System.out.println(lists);
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null)return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        Node node=new Node();
//        node.setLev(0);
//        node.setNode(root);
//        queue.add(root);
        queue.add(root);


//        Queue<Node> queue=new LinkedList<>();
//        Node node=new Node();
//        node.setLev(0);
//        node.setNode(root);
////        queue.add(root);
//        queue.add(node);

        List<List<Integer>> lists = new ArrayList<>();
        int lev = 0;
        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            Node poll = queue.poll();
//            Node poll = queue.poll();
//            int lev=poll.getLev();
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
//                Node poll1 = queue.poll();
                TreeNode poll = queue.poll();
//                poll.left
                if(poll==null){
                    continue;
                }
                list.add(poll.val);

                if (poll.left != null) {
//                    poll.left.setLev(lev+1);
//                    poll.getNode().left.
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }

//                if(lev%2==0){
////                一下子就只有两个
////                他的 lev 是不是一定要 设置的啊
//                    if(poll.getNode().left!=null){
////                    poll.getNode().left.
//                        queue.add(poll.left);
//                    }
//                    if(poll.left!=null){
//                        poll.left.setLev(lev+1);
////                    poll.getNode().left.
//                        queue.add(poll.left);
//                    }
//
//                    if(poll.right!=null){
//                        queue.add(poll.right);
//                    }
//
////                queue.add(poll.right);
//                }else{
//                    if(poll.right!=null){
//                        queue.add(poll.right);
//                    }
//                    if(poll.left!=null){
//                        queue.add(poll.left);
//                    }
//                }
            }
            lists.add(list);

            lev++;
        }
        List<List<Integer>> listsRevsd= new ArrayList<>();
        for (int i = lists.size()-1; i >=0 ; i--) {
            listsRevsd.add(lists.get(i));
        }
        return listsRevsd;

//        lists.add();
//        lists.stream().
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


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        二叉树的层序遍历2_107 二叉树的层序遍历2_107=new 二叉树的层序遍历2_107();
      return   二叉树的层序遍历2_107.levelOrderBottom(root);
    }

    public static void main(String[] args) {

    }
}