/* 1814. Count Nice Pairs in an Array - Medium

You are given an array nums that consists of non-negative integers. Let us define rev(x) 
as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.

Example 1:
Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.

Example 2:
Input: nums = [13,10,35,24,76]
Output: 4
 
Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 109 */

class Solution {

    public int countNicePairs(int[] nums) {

        final int mod = 1000000007;
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            nums[i] = nums[i] - reverse(nums[i]);
        }

        Arrays.sort(nums);
        long res = 0;

        for (int i = 0; i < len - 1; i++) {

            long count = 1;
            while (i < len - 1 && nums[i] == nums[i + 1]) {

                count++;
                i++;
            }
            res = (res % mod + (count * (count - 1)) / 2) % mod;
        }
        return (int) (res % mod);
    }

    private int reverse(int num) {

        int rev = 0;
        while (num > 0) {
            
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
//Time Complexity: O(n log n)
//Space Complexity: O(1)