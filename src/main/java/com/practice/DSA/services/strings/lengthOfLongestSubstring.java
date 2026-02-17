package com.practice.DSA.services.strings;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class lengthOfLongestSubstring {
    public static int f(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        if (s.equals("")) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int curr_str_len;
        int final_str_len = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);


            if (charMap.containsKey(ch) && charMap.get(ch) >= l) {
                l = charMap.get(ch) + 1;

            }
            charMap.put(ch, i);

            r += 1;

            curr_str_len = r - l;
            if (curr_str_len >= final_str_len) {
                final_str_len = curr_str_len;
            }


        }
        return final_str_len;
    }
}
