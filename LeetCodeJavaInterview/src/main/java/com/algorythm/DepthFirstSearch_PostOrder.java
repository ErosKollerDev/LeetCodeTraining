package com.algorythm;

//TODO  Depth First Search  (DSF) Recursive
public class DepthFirstSearch_PostOrder {
    static Node root;
    public static void main(String[] args) {
        DepthFirstSearch_PostOrder dfs = new DepthFirstSearch_PostOrder();
        dfs.insert(47);
        dfs.insert(21);
        dfs.insert(76);
        dfs.insert(18);
        dfs.insert(27);
        dfs.insert(52);
        dfs.insert(82);
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
}
