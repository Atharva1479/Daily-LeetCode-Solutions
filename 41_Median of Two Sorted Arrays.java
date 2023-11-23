/* 4. Median of Two Sorted Arrays - Hard

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 
Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {

                merged.add(nums1[i++]);
            } 
            else {

                merged.add(nums2[j++]);
            }
        }
        
        while (i < nums1.length) merged.add(nums1[i++]);
        while (j < nums2.length) merged.add(nums2[j++]);
        
        int mid = merged.size() / 2;
        if (merged.size() % 2 == 0) {

            return (merged.get(mid-1) + merged.get(mid)) / 2.0;
        } 
        else {
            
            return merged.get(mid);
        }
    }
}
//Time Complexity: O(m+n), where m and n are the lengths of nums1 and nums2 respectively.
//Space Complexity: O(m+n)