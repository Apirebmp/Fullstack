package com.workshop.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/tutorial")
public class TutorialController {

    @GetMapping({"","/"})
    public String getTutorial(
        @RequestParam(name ="id",required = false, defaultValue = "0") Integer id
    ) {
        System.out.println("-----getTutorial-----");
        System.err.println("ID;"+id);  
        return "index";//view ไปหน้าไหน
    }
    

    @GetMapping("/{id}")
    public String getTutorialPath(
        @PathVariable(name ="id") Integer id
    ) {
        System.out.println("-----getTutorial-----");
        System.err.println("ID;"+id);  
        return "index";//view ไปหน้าไหน
    }

    //******POST กับ POSt ชนกันไม่ได้ ตรงนี้ @PostMapping("/")******

    /*@PostMapping("/")
    public String PostTutorial(
        @RequestParam(name ="id",required = false, defaultValue = "0") Integer id
    ) {
        System.out.println("-----getTutorial-----");
        System.err.println("ID;"+id);  
        return "index";//view ไปหน้าไหน
    }*/

    @PostMapping("/")
    public String postTutorial(
        @RequestParam() Map<String, String> param
        ) {
        
            System.out.println("-------posttutorial------------");
            System.out.println("ID:"+param.get("id"));
            System.out.println("code:"+param.get("code"));
        return "index";
    }

}
