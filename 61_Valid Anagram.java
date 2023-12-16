/* 
242. Valid Anagram - Easy

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters. */

//Approach 1:
/* class Solution {

    public boolean isAnagram(String s, String t) {

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);
        return Arrays.equals(charArrayS, charArrayT);
    }
}*/
//Time Complexity: O(n log n)
//Space Complexity: O(1)

//Approach 2:

class Solution {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {

            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {

            if (count[t.charAt(i) - 'a'] == 0) {

                return false;
            }
            count[t.charAt(i) - 'a'] -= 1;
        }
        return true;        
    }
}
//Time complexity: O(n)
//Space complexity: O(1)