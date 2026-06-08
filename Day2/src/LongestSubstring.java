/*
Longest Substring Without Repeating Characters (LeetCode 3, Medium)
Problem Statement:
Given a string s, find the length of the longest substring without repeating characters.
Examples:
• Input: s = "abcabcbb". Output: 3. ("abc")
• Input: s = "bbbbb". Output: 1. ("b")
• Input: s = "pwwkew". Output: 3. ("wke")
 */
import java.util.*;
import java.util.HashSet;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
// public class LongestSubstring 
// {
//     public static int LengthLongestSubString(String s)
//     {
//         int maxlen=0;
//         int left=0;
//         HashMap<Character, Integer> charMap = new HashMap<>();
//         for(int right=0; right<s.length(); right++)
//         {
//             char currentChar = s.charAt(right);
//             if(charMap.containsKey(currentChar) && charMap.get(currentChar) >= left)
//             {
//                 left = charMap.get(currentChar) + 1;
//             }
//             charMap.put(currentChar, right);
//             maxlen = Math.max(maxlen, right - left + 1);
//         }

//         return maxlen;
//     }
//     public static void main(String[] args)
//     {
//         String s = "abcabcbb";
//         int result = LengthLongestSubString(s);
//         System.out.println("Length of the longest substring without repeating characters: " + result);
//     }
// }

