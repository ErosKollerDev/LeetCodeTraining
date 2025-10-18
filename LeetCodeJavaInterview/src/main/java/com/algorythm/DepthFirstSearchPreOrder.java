package com.algorythm;

import java.util.ArrayList;

import static com.util.PrintHelper.printArray;

//TODO  Depth First Search  (DSF) Recursive
public class DepthFirstSearchPreOrder {
    static Node root;

    public static void main(String[] args) {
        DepthFirstSearchPreOrder dfs = new DepthFirstSearchPreOrder();
        dfs.insert(47);
        dfs.insert(21);
        dfs.insert(76);
        dfs.insert(18);
        dfs.insert(27);
        dfs.insert(52);
        dfs.insert(82);
        ArrayList<Integer> results = dfs.DFSPreOrder();
        printArray(results);
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            public Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
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
