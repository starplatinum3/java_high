package lab7;

//import chapter25.BST;

import lab5book.RedPackageUtil;

import java.util.*;

public class AVLTree<E extends Comparable<E>> extends BST<E> {
    /**
     * Create a default AVL tree
     */
    public AVLTree() {
    }

    /**
     * Create an AVL tree from an array of objects
     */
    public AVLTree(E[] objects) {
        super(objects);
    }

    @Override
    /** Override createNewNode to create an AVLTreeNode */
    protected AVLTreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<E>(e);
    }

    @Override
    /** Insert an element and rebalance if necessary */
    public boolean insert(E e) {
        boolean successful = super.insert(e);
        if (!successful)
            return false; // e is already in the tree
        else {
            balancePath(e); // Balance from e to the root if necessary
        }

        return true; // e is inserted
    }

    /**
     * Update the height of a specified node
     */
    private void updateHeight(AVLTreeNode<E> node) {
        if (node.left == null && node.right == null) // node is a leaf
            node.height = 0;
        else if (node.left == null) // node has no left subtree
            node.height = 1 + ((AVLTreeNode<E>) (node.right)).height;
        else if (node.right == null) // node has no right subtree
            node.height = 1 + ((AVLTreeNode<E>) (node.left)).height;
        else
            node.height = 1 +
                    Math.max(((AVLTreeNode<E>) (node.right)).height,
                            ((AVLTreeNode<E>) (node.left)).height);
    }

    /**
     * Balance the nodes in the path from the specified
     * node to the root if necessary
     */
    private void balancePath(E e) {
        java.util.ArrayList<TreeNode<E>> path = path(e);
        for (int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> A = (AVLTreeNode<E>) (path.get(i));
            updateHeight(A);
            AVLTreeNode<E> parentOfA = (A == root) ? null :
                    (AVLTreeNode<E>) (path.get(i - 1));

            switch (balanceFactor(A)) {
                case -2:
                    if (balanceFactor((AVLTreeNode<E>) A.left) <= 0) {
                        balanceLL(A, parentOfA); // Perform LL rotation
                    } else {
                        balanceLR(A, parentOfA); // Perform LR rotation
                    }
                    break;
                case +2:
                    if (balanceFactor((AVLTreeNode<E>) A.right) >= 0) {
                        balanceRR(A, parentOfA); // Perform RR rotation
                    } else {
                        balanceRL(A, parentOfA); // Perform RL rotation
                    }
            }
        }
    }

    /**
     * Return the balance factor of the node
     */
    private int balanceFactor(AVLTreeNode<E> node) {
        if (node.right == null) // node has no right subtree
            return -node.height;
        else if (node.left == null) // node has no left subtree
            return +node.height;
        else
            return ((AVLTreeNode<E>) node.right).height -
                    ((AVLTreeNode<E>) node.left).height;
    }

    /**
     * Balance LL (see Figure 27.1)
     */
    private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy

        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        A.left = B.right; // Make T2 the left subtree of A
        B.right = A; // Make A the left child of B
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
    }

    /**
     * Balance LR (see Figure 27.1c)
     */
    private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy
        TreeNode<E> C = B.right; // B is right-heavy

        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        A.left = C.right; // Make T3 the left subtree of A
        B.right = C.left; // Make T2 the right subtree of B
        C.left = B;
        C.right = A;

        // Adjust heights
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);
    }

    /**
     * Balance RR (see Figure 27.1b)
     */
    private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy

        if (A == root) {
            root = B;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }

        A.right = B.left; // Make T2 the right subtree of A
        B.left = A;
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
    }

    /**
     * Balance RL (see Figure 27.1d)
     */
    private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy
        TreeNode<E> C = B.left; // B is left-heavy

        if (A == root) {
            root = C;
        } else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }

        A.right = C.left; // Make T2 the right subtree of A
        B.left = C.right; // Make T3 the left subtree of B
        C.left = A;
        C.right = B;

        // Adjust heights
        updateHeight((AVLTreeNode<E>) A);
        updateHeight((AVLTreeNode<E>) B);
        updateHeight((AVLTreeNode<E>) C);
    }

    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E element) {
        if (root == null)
            return false; // Element is not in the tree

        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left children (See Figure 23.6)
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (element.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;

                // Balance the tree if necessary
                balancePath(parent.element);
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost is current
                parentOfRightMost.left = rightMost.left;

            // Balance the tree if necessary
            balancePath(parentOfRightMost.element);
        }

        size--;
        return true; // Element inserted
    }

    /**
     * AVLTreeNode is TreeNode plus height
     */
    protected static class AVLTreeNode<E extends Comparable<E>>
            extends BST.TreeNode<E> {
        protected int height = 0; // New data field

        public AVLTreeNode(E o) {
            super(o);
        }
    }

//  void genData(){
//    Random random = new Random();
////    随机生成50000个数字，并
////    List<Integer>list=new ArrayList<>();
//    int siz=50000;
//    Integer [] arr=new Integer[siz];
//    for (int i = 0; i <50000 ; i++) {
//      int rndInt=(int) RedPackageUtil.random(random,0,1111111);
////      list.add((int) RedPackageUtil.random(random,0,1111111));
//      arr[i]=rndInt;
//    }
//
//    Integer[] clone = arr.clone();
//    ArrayUtils.shuffle(clone);
//  }


    static void showTest() {
//      可以显示
//   但是 7个数字 他就很大了 万一 5000个数字 肯定显示不了了
//   https://blog.csdn.net/lenfranky/article/details/89645755
        // 根据给定的数组创建一棵树
//    TreeNode root = ConstructTree.constructTree(new Integer[] {1, 2, 3, 4, 5 ,6, 7});
        int siz = 20;
        Integer[] arr = new Integer[siz];
        Random random = new Random();
        for (int i = 0; i < siz; i++) {
            int rndInt = (int) RedPackageUtil.random(random, 0, 1111111);
//      list.add((int) RedPackageUtil.random(random,0,1111111));
            arr[i] = rndInt;
        }
//    BST<Integer> bst =new BST<>(new Integer[] {1, 2, 3, 4, 5 ,6, 7});
        BST<Integer> bst = new BST<>(arr);
        // 将刚刚创建的树打印出来
//    TreeOperation.show(root);
        BST.show(bst.root);
//————————————————
//    版权声明：本文为CSDN博主「LenFranky」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/lenfranky/article/details/89645755
    }

    static void searchTest() {
        Random random = new Random();
//    随机生成50000个数字，并
//    List<Integer>list=new ArrayList<>();
        int siz = 50000;

        int maxNum = 999999999;
//        int siz = 20;
//        Integer[] arr = new Integer[siz];
//        for (int i = 0; i < siz; i++) {
//            int rndInt = (int) RedPackageUtil.random(random, 0, 1111111);
////      list.add((int) RedPackageUtil.random(random,0,1111111));
//            arr[i] = rndInt;
//        }

//      Integer[] arr = RedPackageUtil.getRndIntArr(siz, 0, 99);
        Integer[] arr = RedPackageUtil.getRndIntArr(siz, 0, maxNum);

        Integer[] searchLst = arr.clone();
        Integer[] delLst = arr.clone();
        ArrayUtils.shuffle(searchLst);
        ArrayUtils.shuffle(delLst);

        calBst(arr, searchLst, delLst);
        calAvl(arr, searchLst, delLst);
//    BST 耗时 31 ms
//    AVLTree 耗时 38 ms

//      BST 搜索 耗时 52 ms
//      BST 删除 耗时 45 ms
//      AVLTree 搜索 耗时 46 ms
//      AVLTree 删除 耗时 91 ms
//
//    //    BST<Integer>bst=new BST<>(list);
//    BST<Integer>bst=new BST<>(arr);
////    Collections.shuffle(list)
////    Arrays.shu
//    long start = System.currentTimeMillis();
//    for (Integer integer : clone) {
//      boolean search = bst.search(integer);
//    }
//    long end = System.currentTimeMillis();
//    long waste=end-start;
//    System.out.println("BST 耗时 "+waste+" ms");
////    list.forEach(o->);
//
//    AVLTree<Integer>avlTree=new AVLTree<>(arr);

    }

    public static void main(String[] args) {

//        showTest();
        searchTest();
    }

    static void calBst(Integer[] arr, Integer[] searchLst, Integer[] delLst) {
        //    BST<Integer>bst=new BST<>(list);
        BST<Integer> bst = new BST<>(arr);
//    Collections.shuffle(list)
//    Arrays.shu
//        BST.show(bst.root);
        long start = System.currentTimeMillis();
        for (Integer integer : searchLst) {

            boolean search = bst.search(integer);
//          System.out.println(String.format(" %d searched? %b", integer,search));
//          java % bool
//          java % bool 字符串  format
//          https://blog.csdn.net/weixin_35473090/article/details/115078916
        }
        long end = System.currentTimeMillis();
        long waste = end - start;
        System.out.println("BST 搜索 耗时 " + waste + " ms");
//    list.forEach(o->);

        start = System.currentTimeMillis();
        for (Integer integer : delLst) {

            boolean deleted = bst.delete(integer);
//          System.out.println(String.format(" %d searched? %b", integer,search));
//          java % bool
//          java % bool 字符串  format
//          https://blog.csdn.net/weixin_35473090/article/details/115078916
        }
        end = System.currentTimeMillis();
        waste = end - start;
        System.out.println("BST 删除 耗时 " + waste + " ms");
    }

    static void calAvl(Integer[] arr, Integer[] searchLst, Integer[] delLst) {
        //    BST<Integer>bst=new BST<>(list);
//    BST<Integer>bst=new BST<>(arr);
        AVLTree<Integer> avlTree = new AVLTree<>(arr);
//    Collections.shuffle(list)
//    Arrays.shu
//        avlTree.show();
        long start = System.currentTimeMillis();
        for (Integer integer : searchLst) {
            boolean search = avlTree.search(integer);
//          System.out.println(String.format(" %d searched? %b", integer,search));
        }
        long end = System.currentTimeMillis();
        long waste = end - start;
        System.out.println("AVLTree 搜索 耗时 " + waste + " ms");
//    list.forEach(o->);

        start = System.currentTimeMillis();
        for (Integer integer : delLst) {

            boolean deleted = avlTree.delete(integer);
//          System.out.println(String.format(" %d searched? %b", integer,search));
//          java % bool
//          java % bool 字符串  format
//          https://blog.csdn.net/weixin_35473090/article/details/115078916
        }
        end = System.currentTimeMillis();
        waste = end - start;
        System.out.println("AVLTree 删除 耗时 " + waste + " ms");

    }

}
