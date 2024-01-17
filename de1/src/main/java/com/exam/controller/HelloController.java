package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("hello")
    public void test(@RequestParam String user, @RequestParam int tuoi) {
        System.out.println("user:" + user);
        System.out.println("tuoi:" + tuoi);
    }

    @RequestMapping("abc/{id}/{ten}")
    public void test2(@PathVariable int id,@PathVariable String ten) {
        System.out.println("Id:" + id);
        System.out.println("ten:" + ten);
    }

}
