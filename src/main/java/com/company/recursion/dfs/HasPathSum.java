package com.company.recursion.dfs;

import com.company.tree.binaryTrees.BinaryTree;
import com.company.tree.binaryTrees.Node;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createSmallTree();
//        System.out.println(hasPathSum(binaryTree.getRoot(),50));
//        System.out.println(hasPathSum(binaryTree.getRoot(),62));
//        System.out.println(hasPathSum(binaryTree.getRoot(),0));
        System.out.println(findPaths(binaryTree.getRoot(),12));
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        // base case
        if(root == null) return  false;
        if(root.left == null && root.right == null)
            return root.data.compareTo(targetSum) == 0;

        // recursive case
        if(!hasPathSum(root.left, targetSum - (Integer) root.data))
            return hasPathSum(root.right, targetSum - (Integer) root.data);
        return true;
    }
    public static  List<List<Integer>> findPaths(Node root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPaths(root.left, targetSum - (Integer) root.data, new ArrayList<>());
        findPaths(root.right, targetSum - (Integer) root.data, new ArrayList<>());
        return  allPaths;
    }

    private static void findPaths(Node root, int targetSum, List<Integer> path){
        // base case
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(root.data.compareTo(targetSum) == 0)
                path.add((Integer) root.data);
            else
                return;
        }
//
//        // recursive case
//        if(!hasPathSum(root.left, targetSum - (Integer) root.data))
//            return hasPathSum(root.right, targetSum - (Integer) root.data);
//        return true;
    }
}
