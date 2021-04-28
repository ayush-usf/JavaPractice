package com.company.recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Permutations {

    public static void main(String[] args) {
//        System.out.println(permute(new int[]{4, 6, 9}));

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 2;
            }
        };

        map.put(1,1);
        System.out.println(map);
        map.put(2,2);
        System.out.println(map);
        System.out.println(map.get(2));
        map.put(3,3);
        System.out.println(map);
        map.put(4,4);
        System.out.println(map);
        map.put(5,5);
        System.out.println(map);
    }
    

    public static List<List<Integer>> permute(int[] arr) {
        
        List<List<Integer>> allPermutations = new ArrayList<>();
        
        permute(arr, new ArrayList<>(), allPermutations);
        return allPermutations;
    }

    private static void permute(int[] arr, List<Integer> runningChoices, List<List<Integer>> allPermutations) {

        if (runningChoices.size() == arr.length) {
            allPermutations.add(new ArrayList<>(runningChoices));
            return;
        }

        /*
          Every stack frame of this function call represents the expression
          of trying (almost) all items in every "slot" in the array.
          The recursion stops when we are choosing on 1 past the final "slot".
        */
        for (int i = 0; i < arr.length; i++) {
            int choice = arr[i];

            // Skip if element already exists in 'runningChoices'
            if (runningChoices.contains(choice)) {
                continue;
            }

            // 1.) Choose - Add the item to the 'runningChoices'
            runningChoices.add(choice);
            System.out.println("runningChoices "+runningChoices);

            // 2.) Explore - Recurse on the choice
            permute(arr, runningChoices, allPermutations);

            // 3.) Unchoose - We have returned from the recursion, remove the choice we made.
            // The next iteration will try another item in the "slot" we are working on.
            runningChoices.remove(runningChoices.size() - 1);
        }
    }
}
