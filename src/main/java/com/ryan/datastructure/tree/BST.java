package com.ryan.datastructure.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ryanzou
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
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
     * 搜索某个元素e
     *
     * @param e
     * @return
     */
    public Node search(E e) {
        return search(root, e);
    }

    private Node search(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            return search(node.left, e);
        } else {
            return search(node.right, e);
        }
    }

    private Node searchParent(E e) {
        return searchParent(root, e);
    }

    private Node searchParent(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0 && node.left != null) {
            if (e.compareTo(node.left.e) == 0) {
                return node;
            } else {
                return searchParent(node.left, e);
            }
        } else if (e.compareTo(node.e) > 0 && node.right != null) {
            if (e.compareTo(node.right.e) == 0) {
                return node;
            } else {
                return searchParent(node.right, e);
            }
        } else {
            return null;
        }
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
        return node;
    }


    /**
     * （深度优先遍历）
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * （深度优先遍历）
     * 前序遍历
     * 不实用递归来实现
     * 使用栈来实现前序遍历
     */
    public void preOrderByStack() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            System.out.println(curNode);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }


    /**
     * （深度优先遍历）
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node);
        midOrder(node.right);
    }

    /**
     * （深度优先遍历）
     * 后序遍历
     */
    public void lastOrder() {
        lastOrder(root);
    }

    private void lastOrder(Node node) {
        if (node == null) {
            return;
        }

        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node);
    }


    /**
     * 广度优先遍历（通过队列逐层遍历树）
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            System.out.println(curNode);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }


    /**
     * 删除二分查找树的某个节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除node为跟树中的指定节点
     *
     * @param node 以node为跟的树删除元素e
     * @param e
     * @return 返回删除元素之后的新树
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            } else if (node.right == null)  {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            } else {
                Node minRightNode = getMinNode(node.right);
                minRightNode.right = remove(node.right, minRightNode.e);
                minRightNode.left = node.left;
                node.left = node.right = null;
                return minRightNode;
            }
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


    public static void main(String[] args) {
        BST bst = new BST();
        bst.addEle(7);
        bst.addEle(3);
        bst.addEle(10);
        bst.addEle(1);
        bst.addEle(5);
        bst.addEle(9);
        bst.addEle(12);
//        System.out.println(bst.size);
//        System.out.println(bst.search(5));
//        System.out.println(bst.searchParent(5));
        System.out.println("----------------前序遍历-----------------");
        bst.preOrder();
        System.out.println("----------------中序遍历-----------------");
        bst.midOrder();
        System.out.println("----------------后序遍历-----------------");
        bst.lastOrder();
        System.out.println("----------------递归前序遍历-----------------");
        bst.preOrderByStack();
        System.out.println("----------------广度优先遍历-----------------");
        bst.levelOrder();
        System.out.println("----------------删除节点-----------------");
        bst.remove(3);
        bst.midOrder();
    }

}
