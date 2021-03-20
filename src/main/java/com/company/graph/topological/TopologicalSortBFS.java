package com.company.graph.topological;

import java.util.*;

public class TopologicalSortBFS {
    public static List<Integer> top_sort(int vertices, int[][] edges){

        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0)  return  sortedOrder;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegMap = new HashMap<>(vertices);
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i <  vertices; i++){
            inDegMap.put(i,0);
            graph.put(i, new LinkedList<>());
        }

        // Finding the source
        for(int i = 0; i <  edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            inDegMap.put(child,inDegMap.get(child) + 1);
        }

        // Adding all sources to Queue
        for(Integer vertex: inDegMap.keySet()){
            if(inDegMap.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        while (!queue.isEmpty()){
            Integer node = queue.poll();
            sortedOrder.add(node);

            for(Integer child : graph.get(node)){

                int newInDeg = inDegMap.get(child)-1;
                inDegMap.put(child, newInDeg);
                if(newInDeg  == 0){
                    queue.add(child);
                }
            }
        }
        if(sortedOrder.size() != vertices) return new ArrayList<>();
        return sortedOrder;
    }

    public static void main(String[] args) {
        // To do 2, you need 3.
        // To do 0 you need 3
        // To do 0, you need 2
        // To do 1, you need 2

        // 2 0 3 1
        // for loop, check if any node on 0th, idx is not at 1th
        int[][] arr = new int[][]{new int[]{3,2}, new int[] {3, 0}, new int[]{2,0}, new int[]{2,1}};
    }
}
