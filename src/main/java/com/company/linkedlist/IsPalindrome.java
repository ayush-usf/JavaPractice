package com.company.linkedlist;

public class IsPalindrome {

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }

    static boolean isListPalindrome(ListNode<Integer> l) {
        // Find the middle node - findMiddleNode fn // O(n)
        // Store the reference of middle node.next // for iteration in last step // O(1)
        // Reverse the first half till the middle node  - reverse fn // O(n/2) ~ O(n)
        // Iterate from both sides and compare // O(n)
        if(l == null) return false;
        if(l.next == null) return true;
        if(l.next.next == null) return l.value == l.next.value;

        ListNode[] middleTwo = findMiddleNode(l);
        ListNode mid1 = middleTwo[0];
        System.out.println("middleTwo[1] "+ middleTwo[1].value);
        boolean isOddTerms = middleTwo[1].value.equals(1);
        ListNode reverseMid = reverseTillMid(l, mid1);

         ListNode<Integer> curr = l;
         // 1 2 1
         // 1 2 2 1
         if(isOddTerms){
             mid1 = mid1.next;
         }
         while(reverseMid != null){
             if(reverseMid.value != mid1.value)
                 return false;
             reverseMid = reverseMid.next;
             mid1 = mid1.next;
         }
        return true;
    }
    private static ListNode reverseTillMid(ListNode head, ListNode mid1){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextRef = null;
        // aba
        // null a b | a
        while(curr != mid1){
            System.out.println("curr :" +curr.value);
            System.out.println("midIncluded :" +mid1);

            // Storing the next reference
            nextRef = curr.next;

            // Swapping/ reversing nodes
            curr.next = prev;
            prev = curr;

            curr = nextRef;
        }
        return prev;
    }

    private static ListNode[] findMiddleNode(ListNode head){
        ListNode[] arr = new ListNode[3];
        ListNode slow = head;
        ListNode fast = head;
        // 1 2 1
        boolean isOddTerms = false;
        // 1,2,3 4
        //   S     F
        while(fast != null){
            // System.out.println("slow 1 :" +slow.value);
            // System.out.println("slow 2 :" +slow.value);
            if(fast.next == null){
                isOddTerms = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        arr = isOddTerms == false ? new ListNode[]{slow, new ListNode(1)} : new ListNode[]{slow, new ListNode(1)};
        return arr;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode(1);
        ListNode<Integer> node = head;
        node.next = new ListNode(2);
        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;

        System.out.println(isListPalindrome(head));
    }
}
