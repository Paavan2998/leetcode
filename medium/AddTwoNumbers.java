package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode num3 = new ListNode(3);
        ListNode num2 = new ListNode(4, num3);
        ListNode num1 = new ListNode(2, num2);
        ListNode num6 = new ListNode(4);
        ListNode num5 = new ListNode(6, num6);
        ListNode num4 = new ListNode(5, num5);
        System.out.println(addTwoNumbers(num1, num4));
    }

    /*
    * code duplication see below solution for concise solution */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        } else if (l2 == null && l1 != null) {
            return l1;
        } else if (l2 == null && l1 == null) {
            return new ListNode(0);
        }else{
            ListNode ans = new ListNode();
            ListNode preNode = null;
            int carry = 0;
            while(l1 != null && l2 != null){
                int sum = l1.val + l2.val + carry;
                if(sum >= 10){
                    sum = sum - 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                if(preNode == null){
                    preNode = new ListNode(sum);
                    ans = preNode;
                }else{
                    preNode.next = new ListNode(sum);
                    preNode = preNode.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1 != null){
                while(l1 != null){
                    int sum = l1.val + carry;
                    if(sum >= 10){
                        sum = sum - 10;
                        carry = 1;
                    }else{
                        carry = 0;
                    }
                    if(preNode == null){
                        preNode = new ListNode(sum);
                        ans = preNode;
                    }else{
                        preNode.next = new ListNode(sum);
                        preNode = preNode.next;
                    }
                    l1 = l1.next;
                }
            }else if (l2 != null){
                while(l2 != null){
                    int sum = l2.val + carry;
                    if(sum >= 10){
                        sum = sum - 10;
                        carry = 1;
                    }else{
                        carry = 0;
                    }
                    if(preNode == null){
                        preNode = new ListNode(sum);
                        ans = preNode;
                    }else{
                        preNode.next = new ListNode(sum);
                        preNode = preNode.next;
                    }
                    l2 = l2.next;
                }
            }
            if(carry == 1){
                preNode.next = new ListNode(1);
            }
            return ans;
        }
    }

    /*
    * Leetcode solution it has same time complexity and slightly better space complexity
    * But the code is very concise */
    public static ListNode addTwoNumbersLeetCodeSolution(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; // intialising our sum
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
