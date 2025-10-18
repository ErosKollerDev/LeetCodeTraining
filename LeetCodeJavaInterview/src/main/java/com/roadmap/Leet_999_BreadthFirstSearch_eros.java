package com.roadmap;


import com.algorythm.Node;
import com.util.PrintHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO Breadth First Search (BFS)
public class Leet_999_BreadthFirstSearch_eros {
    static Node root;

    public static void main(String[] args) {
        Leet_999_BreadthFirstSearch_eros bfs = new Leet_999_BreadthFirstSearch_eros();
//        root = new Node(0);
        bfs.insert(47);
        bfs.insert(21);
        bfs.insert(76);
        bfs.insert(18);
        bfs.insert(27);
        bfs.insert(52);
        bfs.insert(82);

        ArrayList<Integer> results = bfs.breadthFirstSearch();
        PrintHelper.printArray(results.stream().mapToInt(i -> i).toArray());

    }

    //ArrayList<Integers>  breadthFirstSearch()
    //boolean insert(int value)

    private ArrayList<Integer> breadthFirstSearch() {
       ArrayList<Integer> result = new ArrayList<>();
       Queue<Node> q = new LinkedList();
       Node curret = root;
       q.offer(curret);
       while(!q.isEmpty()){
            curret = q.remove();
            result.add(curret.value);
            if(curret.left != null ) q.offer(curret.left);
            if(curret.right != null ) q.offer(curret.right);
       }
       return result;
    }

    public boolean insert(int value) {
        //build a new Node
        Node newNode = new Node(value);
        //test is root is null, if it is, assign the new node to root and return true; End.
        if (root == null) {
            root = newNode;
            return true;
        }
        //Assign temp to root
        Node temp = root;
        //Infinite Loop (true)
        while (true) {
            // if newNode.value == temp.value (Nothing to do) return false, don't insert something that's already there
            if (newNode.value == temp.value) {
                return false;
            }
            // (left) if newNode.value is less than temp.value (left side), test is left is null, if it is, assign to temp.left, if not temp == temp.left to kick the loop again
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                }
                temp = temp.left;
            }
            // (right) if newNode.value is less than temp.value (right side), test is right is null, if it is, assign to temp.right, if not temp == temp.right to kick the loop again
            else {
                if(temp.right == null){
                    temp.right = newNode;
                }
                temp = temp.right;
            }
        }
    }

//    public boolean contains(int value) {
//        if (root == null) return false;
//        Node temp = root;
//        while (temp != null) {
//            if (value < temp.value) {
//                temp = temp.left;
//            } else if (value > temp.value) {
//                temp = temp.right;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }


}
