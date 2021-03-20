package com.company.linkedlist;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }

    private static int find(int num) {
        int slow = num, fast = num;
        while (true) {
            slow = findSumOfDigits(slow);  // slow = slow.next
            fast = findSumOfDigits(findSumOfDigits(fast));  // fast = fast.next.next
            if (slow == fast)
                return slow;
            num = fast;
        }
    }

    private static int findSumOfDigits(int num) {
        int remSq = 0;
        while (num> 0) {
            int rem = num % 10;
            remSq += rem * rem;
            num /= 10;
        }
        return remSq;
    }
}
