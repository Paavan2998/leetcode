package easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * */
public class twoSum {
    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2,3,4,5,6,7,8};
        int[] ans = twoSumUsingHashMap(nums, target);
        Arrays.stream(ans).forEach(i -> System.out.println(i));
    }

    //    brute force method
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    //    hash map method takes 4ms to execute
    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int num2 = target - nums[i];
            if(hashMap.get(num2) != null){
                ans[0] = i;
                ans[1] = hashMap.get(num2);
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return ans;
    }

//  improve hashmap method
//  previous solution each time the for loop executed it calculated nums.length which is time-consuming
//  store nums.length in variable 'n' and use that
//  take 1ms to execute
    public static int[] improvedTwoSumUsingHashMap(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for(int i=0; i<n; i++){
            int num2 = target - nums[i];
            if(hashMap.get(num2) != null){
                ans[0] = i;
                ans[1] = hashMap.get(num2);
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return ans;
    }
}
