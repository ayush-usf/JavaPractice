package com.company.graph.topological;

import java.util.*;

public class TopologicalSortAllBFS {
    public static int[][] top_sort(int vertices, int[][] edges){

        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0)  return new int[0][0];

        // Inititalize the graph
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>(vertices);
        HashMap<Integer, Integer> inDegMap = new HashMap<>(vertices);

        for(int i = 0; i <  vertices; i++){
            graph.put(i, new LinkedList<>());
            inDegMap.put(i,0); // don't replace it with getOrDefault below, fails for [0,1]
        }

        // Building the Graph - Creating the adjacency list
        for(int i = 0; i <  edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child);
            // increment child's in degree - tracking incoming edges cnt
            inDegMap.put(child,inDegMap.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        // Finding the sources and adding  to Queue
        for(Integer vertex: inDegMap.keySet()){
            if(inDegMap.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }
        if(queue.size() == 0) return new int[0][0];

        printOrdering(graph, inDegMap, queue, sortedOrder);
        return new int[0][0];
    }

    private static void printOrdering(HashMap<Integer, LinkedList<Integer>> graph, HashMap<Integer, Integer> inDegMap, Queue<Integer> queue, List<Integer> sortedOrder) {
//        while (!queue.isEmpty()){
//            Integer node = queue.poll();
//            sortedOrder.add(node);
//
//            for(Integer child : graph.get(node)){
//
//                // remove all the edges from this source
//                inDegMap.put(child, inDegMap.get(child)-1);
//                if(inDegMap.get(child)  == 0){
//                    queue.offer(child);
//                }
//            }
//            if(graph.get(node).size()>1)
//                queue.offer(node);
//        }
//        if(sortedOrder.size() != vertices) return new int[0][0];
//
//        int[] res = new int[sortedOrder.size()];
//        for(int i = 0; i < sortedOrder.size(); i++){
//            res[i] = sortedOrder.get(i);
//        }
//        return res;
    }

    public static void main(String[] args) {
        // To do 2, you need 3.
        // To do 0 you need 3
        // To do 0, you need 2
        // To do 1, you need 2

        // 2 0 3 1
        // for loop, check if any node on 0th, idx is not at 1th
//        int[][] arr = new int[][]{new int[]{3,2}, new int[] {3, 0}, new int[]{2,0}, new int[]{2,1}};
        int[][] arr = new int[][]{new int[]{1,0}};
        System.out.println(Arrays.toString(top_sort(2, arr)));
    }
}
