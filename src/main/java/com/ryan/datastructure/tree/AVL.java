package com.ryan.datastructure.tree;

import java.util.ArrayList;

/**
 * @author ryanzou
 */
public class AVL<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;
        public int height;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public Node() {

        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public void addEle(E e) {
        this.root = addEle(this.root, e);
    }

    /**
     * 将元素e添加到以node为跟的一个子树
     *
     * @param node
     * @param e
     * @return
     */
    private Node addEle(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addEle(node.left, e);
        } else {
            node.right = addEle(node.right, e);
        }

        // 插入新节点需要维持再平衡
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return balanceNode(node);
    }


    /**
     * 删除指定节点
     *
     * @param e
     */
    public void remove(E e) {
        this.root = remove(this.root, e);
    }

    /**
     * 从AVL树中删除节点，并调整平衡
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        Node retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                Node minRightNode = getMinNode(node.right);
                minRightNode.right = remove(node.right, minRightNode.e);
                minRightNode.left = node.left;
                node.left = node.right = null;
                retNode = minRightNode;
            }
        }

        if (retNode == null) {
            return null;
        }
        return balanceNode(retNode);
    }


    /**
     * 通过判断树的的平衡因子旋转树使其平衡
     *
     * @param node
     * @return
     */
    private Node balanceNode(Node node) {
        if (node == null) {
            return null;
        }
        int balanceFactor = getBalancedFactor(node);

        // 在左边的左边插入新节点导致不平衡（右旋）
        if (balanceFactor > 1 && getBalancedFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        // 在右边的右边插入新节点导致不平衡（左旋）
        if (balanceFactor < -1 && getBalancedFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        // 在左边的右边插入新节点导致不平衡（先左旋再右旋）
        if (balanceFactor > 1 && getBalancedFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 在右边的左边插入新节点导致不平衡（先右旋再左旋）
        if (balanceFactor < -1 && getBalancedFactor(node.left) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 获取一个树的最小节点
     *
     * @param node
     * @return
     */
    private Node getMinNode(Node node) {
        return node.left == null ? node : getMinNode(node);
    }

    /**
     * 左旋
     * <p>
     * 对节点n进行左旋操作，返回旋转厚的新的跟节点r
     * <p>
     * n                                r
     * /   \                            /   \
     * T1    r        向左旋转（n）       n     a
     * /  \       ---------->      / \   / \
     * T2   a                      T1 T2 T3 T4
     * / \
     * T3 T4
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        Node rightNode = node.right;
        node.right = rightNode.left;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        rightNode.left = node;
        rightNode.height = Math.max(getHeight(rightNode.left), getHeight(rightNode.right)) + 1;
        return rightNode;
    }

    /**
     * 右旋
     * <p>
     * 对节点n进行右旋操作，返回旋转厚的新的跟节点r
     * <p>
     * n                                l
     * /   \                            /   \
     * l    T4        向右旋转（n）       a     n
     * /  \             ---------->      / \   / \
     * a   T3                            T1 T2 T3 T4
     * / \
     * T1 T2
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        Node leftNode = node.left;
        node.left = leftNode.right;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        leftNode.right = node;
        leftNode.height = Math.max(getHeight(leftNode.left), getHeight(leftNode.right)) + 1;
        return leftNode;
    }


    /**
     * 判断是否是AVL树，两个条件：
     * 1.是否是BST
     * 2.是否平衡
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<E> elements = new ArrayList<>();

        // 1.先中序遍历二叉树，根据二叉树中序遍历一定是从小到大排序的特性来判断是否是二分查找树
        midOrder(root, elements);
        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i - 1).compareTo(elements.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断左子树与柚子树的高度差是否小于等于1
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int bf = getBalancedFactor(node);
        if (Math.abs(bf) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getBalancedFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 将中序遍历的结果保存到elements
     *
     * @param node
     * @param elements
     */
    private void midOrder(Node node, ArrayList<E> elements) {
        if (node == null) {
            return;
        }
        midOrder(node.left, elements);
        elements.add(node.e);
        midOrder(node.right, elements);
    }

    public static void main(String[] args) {
        AVL avl = new AVL<>();
        avl.addEle(1);
        avl.addEle(2);
        avl.addEle(3);
        avl.addEle(4);
        avl.addEle(5);
        avl.addEle(6);
        avl.addEle(7);
        avl.addEle(8);
        avl.remove(5);
        boolean isBalanced = avl.isBalanced();
        boolean isBST = avl.isBST();

        System.out.println(isBalanced);
        System.out.println(isBST);
    }
}
