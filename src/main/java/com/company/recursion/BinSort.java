package com.company.recursion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BinSort {
    public static void main(String[] args) {
//        3 -Mark
//        1 John
//        2 Mary
//        6 Zack
//        1 Bill
//        3 Sara
        int maxValue = 6;
        Elem[] arr = new Elem[6];
        arr[0] = new Elem(3,"Mark");
        arr[1] = new Elem(1,"John");
        arr[2] = new Elem(2,"Mary");
        arr[3] = new Elem(6,"Zack");
        arr[4] = new Elem(1,"Bill");
        arr[5] = new Elem(6,"Sara");
        binSort(arr,maxValue);
        System.out.println("arr "+ Arrays.toString(arr));
    }

//    public static void binSort(Elem[] arr, int maxValue){
//        int i, insertIndex = 0;
//
//        LinkedList<Elem>[] llist = new LinkedList[maxValue + 1];
//
//        for (i = 0 ; i <= maxValue; i++){
//            llist[i] = new LinkedList<>();
//        }
//
//        for(i = 0; i < arr.length; i++){
//            int key = arr[i].key();
//            llist[key].add(arr[i]);
//        }
//        for (i = 0 ; i <= maxValue; i++){
//            if(llist[i].size() != 0){
//                for(int j = 0; j < llist[i].size(); j++){
//                    arr[insertIndex++] = llist[i].get(j);
//                }
//            }
//        }
//    }

    public static void binSort(Elem[] arr, int maxValue){
        int i, insertIndex = 0;
        // because starting from 0th Idx, not present in list
        LinkedList<Elem>[] llist = new LinkedList[maxValue + 1];

        for (i = 0 ; i <= maxValue; i++){
            llist[i] = new LinkedList<>();
        }

        for(i = 0; i < arr.length; i++){
//            llist[arr[i].key()].add(arr[i]);
            llist[arr[i].key()].addLast(arr[i]);
        }
        for (i = 0 ; i <= maxValue; i++){
            Iterator<Elem> iterator = llist[i].iterator();
            while (iterator.hasNext()){
                arr[insertIndex++] = iterator.next();
            }
        }
    }
}
