/* 
1207. Unique Number of Occurrences - Easy

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 
Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000 */

class Solution {
    
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++){

            if (hashMap.containsKey(arr[i])){

                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }
            else{

                hashMap.put(arr[i], 1);
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();
        boolean flag = true;
        
        for (Map.Entry<Integer, Integer> mapElement : hashMap.entrySet()){

            if (!hashSet.add(mapElement.getValue())){

                flag = false;
            }
        }
        return flag;
    }
}

//Time complexity: O(n)
//Space complexity: O(n)