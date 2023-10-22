/* 217. Contains Duplicate - Easy

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. 

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true 

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109 */

/* Approach 1:

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            // If adjacent elements are the same, it's a duplicate
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        
        return false; // No duplicates found
    }
}
Time: O(n * log(n))
Space: O(1) */

//Approach 2:

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements from the array
        Set<Integer> seen = new HashSet<>();

        // Iterate through the elements of the 'nums' array
        for (int num : nums) {
            // Check if the current element is already in the 'seen' set
            if (seen.contains(num)) {
                return true; // If we have seen the number before, it's a duplicate
            }
            seen.add(num); // Add the current element to the 'seen' set
        }

        // If no duplicates are found during the iteration, return 'false'
        return false; // No duplicates found
    }
}
//Time: O(n)
//Space: O(n)


