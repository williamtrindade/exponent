package com.williamtrindade.longestSubstringWithoutRepeat;

import java.util.*;

class Solution {

    static int longestSubstringWithoutRepeat(String s) {
        // your code goes here
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int windowStart = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); // increment
            } else {
                map.put(c, 1);
            }
            while (map.get(c) > 1) {
                map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1); // +1 cause start on zero
        }
        return max;
    }

    public static void main(String[] args) {
        // debug your code below
        System.out.println(longestSubstringWithoutRepeat("abcdeffghij")); // 10
        System.out.println(longestSubstringWithoutRepeat("abcabcbb")); // 3
        System.out.println(longestSubstringWithoutRepeat("pwwkew")); // 3
    }
}