/*287. Find the Duplicate Number - Medium

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space. 

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n

All the integers in nums appear only once except for precisely one integer which appears two or more times.*/

/*Approach 1
class Solution {
    public int findDuplicate(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {

                return nums[i];
            }
        }
        return 0;
    }
}

Time Complexity:O(Nlogn + N)
Space Complexity:O(1)*/

//Approach 2
public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize slow and fast pointers
        int slow = nums[0]; // Both slow and fast start at the first element of the array.
        int fast = nums[0];

        // Phase 1: Detect if there's a cycle
        do {
            slow = nums[slow]; // Move the slow pointer one step by following the value at its current position.
            fast = nums[nums[fast]]; // Move the fast pointer two steps by following the value at its current position twice.
        } while (slow != fast); // Continue this process until both pointers meet in a cycle.

        // Phase 2: Find the entrance to the cycle
        slow = nums[0]; // Reset the slow pointer to the beginning of the array.

        while (slow != fast) { // Move both slow and fast one step at a time until they meet at the entrance of the cycle.
            slow = nums[slow]; // Move slow one step.
            fast = nums[fast]; // Move fast one step.
        }

        return slow; // The entrance of the cycle is the repeated number, so return it.
    }
}

//Time complexity: O(N)
//Space complexity: O(1)