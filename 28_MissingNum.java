/* 268. Missing Number - Easy

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 
Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique. */

/*Approach 1: 
class Solution {

    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){

            if(nums[i] != i){

                return i;
            }
        }
        return nums.length;
    }
}
Time Complexity: O(n log n)
Space Complexity: O(1) */

//Approach 2:
class Solution {

    // Function to find the missing number in the given range
    public int missingNumber(int[] nums) {

        // Calculate the expected sum of numbers in the range [0, n]
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;

        // Calculate the actual sum of numbers in the array nums
        int actualSum = 0;
        for (int num : nums) {

            actualSum += num;
        }

        // Return the missing number by subtracting the actual sum from the expected sum
        return expectedSum - actualSum;
    }
}
//Time complexity:O(N)
//Space complexity: O(1)

//Approach 3: By using HashMap
import java.util.HashMap;

class Solution {

    public int missingNumber(int[] nums) {

        // Create a HashMap to store the numbers in the array
        HashMap<Integer, Boolean> numMap = new HashMap<>();

        // Populate the HashMap with numbers from the array
        for (int num : nums) {
            numMap.put(num, true);
        }

        // Iterate through the expected numbers in the range [0, n]
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            // If the current number is not in the HashMap, it is the missing number
            if (!numMap.containsKey(i)) {
                return i;
            }
        }

        // If all numbers are present, return -1 or any other indicator of no missing number
        return -1;
    }
}

//Time complexity: O(n)
//Space complexity: O(n) 