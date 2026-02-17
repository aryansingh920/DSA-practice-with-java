package com.practice.DSA.services.strings;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class lengthOfLongestSubstring {
    public static int f(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int l = 0;
        int r = 0;
        String curr_str;
        String final_str = "";
        for (int i = 0; i < s.length() - 1; i++) {

            char ch = s.charAt(i);
            char ch_r = s.charAt(r);

            if (charMap.containsKey(ch) || (charMap.containsKey(ch_r) && charMap.get(ch_r) >= l)) {
                l = charMap.get(ch) + 1;

            }
            charMap.put(ch, i);

            r += 1;

            curr_str = s.substring(l, r);
            if (curr_str.length() >= final_str.length()) {
                final_str = curr_str;
            }


        }
        return final_str.length();
    }
}
