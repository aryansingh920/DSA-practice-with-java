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
        String curr_str="";
        String final_str = "";

        for (int i = 0; i < s.length(); i++) {
            r += 1;
            char ch = s.charAt(i);
            charMap.put(ch, i);

            System.out.println("First");
            System.out.println(charMap);
            System.out.println(curr_str);
            System.out.println(final_str);
            System.out.println("i : "+i+ "l : " + l+"r : "+r);

            if (charMap.containsKey(ch)) {
                l += 1;
            }

            curr_str = s.substring(l, r);
            if (curr_str.length() > final_str.length()) {
                final_str = curr_str;
            }

            System.out.println("Second");
            System.out.println(charMap);
            System.out.println(curr_str);
            System.out.println(final_str);
            System.out.println("i : " + i + "l : " + l + "r : " + r);

        }
    


        return final_str.length();
    }
}
