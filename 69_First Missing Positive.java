/* 41. First Missing Positive - Hard

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing. */

class Solution {
    
    public int firstMissingPositive(int[] nums) {

      Arrays.sort(nums);
      nums = Arrays.stream(nums).filter(n->n>0).distinct().toArray();
       if(nums.length == 0 || nums[0]!=1){

           return 1;
       }
       
      for(int i = 0; i < nums.length - 1 ; i++){

       if((nums[i+1]!=nums[i] + 1 ) && nums[i]>0){

           return nums[i]+1;
       }
      }  
      return nums[nums.length - 1] + 1;
    }
}
//Time complexity: O(n log(n))
//Space complexity: O(n)