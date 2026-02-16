package com.practice.DSA.controllers.strings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.DSA.services.strings.lengthOfLongestSubstring;
import com.practice.DSA.services.strings.service;



@RestController
@RequestMapping("/dsa/string")
public class controller {
    private final service StringService;

    public controller(service StringService) {
        this.StringService = StringService;
    }

    @GetMapping({ "", "/" })
    public String getMethodName() {
        return StringService.getMessage();
    }
    

    @GetMapping("/lengthOfLongestSubstring")
    public int getlengthOfLongestSubstring(@RequestParam String string) {
        return lengthOfLongestSubstring.f(string);
    }
    
}
