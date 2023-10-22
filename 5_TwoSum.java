/*1. Two Sum - Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1] 

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists. */

/*Approach 1:
class Solution {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result; // Return an array with default values [0, 0] if no solution is found.
    }
}
Time: O(n^2)
Space: O(1) */

//Approach 2:

class Solution {

    public int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store elements from the array as keys and their indices as values
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        // Iterate through the nums array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target
            int complement = target - nums[i];
            
            // Check if the complement is already in the HashMap
            if (numToIndex.containsKey(complement)) {
                // If yes, return the indices of the current element and its complement
                return new int[]{numToIndex.get(complement), i};
            }
            
            // If the complement is not found, add the current element and its index to the HashMap
            numToIndex.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array or throw an exception.
        return new int[0];
    }
}
//Time: O(n)
//Space: O(n)


