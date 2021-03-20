package com.company.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeTwoBinaryTrees {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        System.out.println(levelOrder(root1));
        System.out.println(levelOrder(root2));
        System.out.println(levelOrder(mergeTrees(root1, root2)));
    }

    public static TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) return null;
        if(tree1 == null) return tree2;
        if(tree2 == null) return tree1;

        tree1.data += tree2.data;
        tree1.left = mergeTrees(tree1.left, tree2.left);
        tree1.right = mergeTrees(tree1.right, tree2.right);

        return tree1;
    }

    public static List<List<Integer>> levelOrder(TreeNode tree){
        List<List<Integer>> list = new LinkedList<>();
        if(tree == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> subList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                subList.add((Integer) node.data);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(subList);
        }
        return list;
    }
}
