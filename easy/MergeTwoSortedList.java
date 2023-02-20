package easy;

import java.util.LinkedList;

/*
* Input: list1 = [1,2,4], list2 = [1,3,4]
* Output: [1,1,2,3,4,4]
**/
public class MergeTwoSortedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(8);
        list1.add(10);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(4);
        list2.add(5);
        LinkedList<Integer> mergedList = mergeAlgo(list1, list2);
        System.out.println(mergedList.toString());
    }

    public static LinkedList<Integer> mergeAlgo(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> mergedList = new LinkedList<>();
        if(list1.isEmpty() && !list2.isEmpty()){
            return list2;
        }else if(!list1.isEmpty() && list2.isEmpty()){
            return list1;
        }else{
            Integer l1size = list1.size();
            Integer l2size = list2.size();
            Integer n = l2size < l1size ? l2size : l1size;
            int i = 0, j = 0;
            while(i<n && j<n){
                if(list1.get(i) <= list2.get(j)){
                    mergedList.add(list1.get(i));
                    i++;
                }else{
                    mergedList.add(list2.get(j));
                    j++;
                }
            }
            if(i==n){
                for(int l2 = j; l2<l2size; l2++){
                    mergedList.add(list2.get(l2));
                }
            }else if(j==n){
                for(int l1 = i; l1<l1size; l1++){
                    mergedList.add(list1.get(l1));
                }
            }
        }
        return mergedList;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     *
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     */

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //If list1 is null means list2 is already sorted
        if(list1 == null){
            return list2;
        }
        //If list2 is null means list1 is already sorted
        if(list2 == null){
            return list1;
        }

        //Two Temporary variable to store the head of the goven linked list

        ListNode t1 = list1;
        ListNode t2 = list2;

        //ansHead and ansTail will store answer list
        ListNode ansHead = null;
        ListNode ansTail = null;

        //to find the head of the answer linked list

        if(t1.val <= t2.val){
            //set head and tail
            ansHead = t1;
            ansTail = t1;
            t1 = t1.next;
        }
        else{
            //set head and tail
            ansHead = t2;
            ansTail = t2;
            t2 = t2.next;
        }

        //Till now we have decided the first element of the linked list
        //now run a loop till at least one of them has reaced to end or both

        while(t1 != null && t2 != null){

            if(t1.val <= t2.val){//if value in t1 is less than that of t2

                ansTail.next = t1;//add t1 node in answer tail
                ansTail = ansTail.next;//after adding new element the answer tail will move to next
                t1 = t1.next;//as you have visited the current t1 node move t1 to t1.next
            }
            else{

                ansTail.next = t2;//add t2 node in answer tail
                ansTail =ansTail.next;//after adding new element the answer tail will move to next
                t2 = t2.next;//as you have visited the current t1 node move t1 to t1.next
            }
        }

        //If one of the lis is empty then remaining list between t1 and t2 is alread sorted
        if(t1 != null){
            ansTail.next = t1;
        }
        else{
            ansTail.next = t2;
        }

        return ansHead;
    }

}
