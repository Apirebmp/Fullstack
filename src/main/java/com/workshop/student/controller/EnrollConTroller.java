package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/enroll")

public class EnrollConTroller {
    @GetMapping({"","/"})
    public String getAll(){
        System.out.println("----------EnrollControlle getAll()--------");
        return "index";
    }

    @GetMapping("/{enroll-id}")
    public String getbyId(
        @PathVariable(name="enroll-id")Integer enrollID
    ){
        System.out.println("----EnrollControlle getById()------");
        System.out.println("enroll-id:"+enrollID);
        return "index";
    }

    @GetMapping("/delete{enroll-id}")
    public String getDeletebyId(
        @PathVariable(name="enroll-id")Integer enrollID
    ){
        System.out.println("---EnrollControlle getDeleteById()------");
        System.out.println("enroll-id:"+enrollID);
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String>param
        ) {
        
            System.out.println("----Studentcontroller PostInsertAndUpdate-----");
            System.out.println("enroll-id:"+param.get("enroll-id"));
            System.out.println("enroll-name:"+param.get("enroll-name"));

            return "index";
    }
    
}
    

