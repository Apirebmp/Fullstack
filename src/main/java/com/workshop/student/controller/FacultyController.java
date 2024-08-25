package com.workshop.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.service.FacultyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping({"","/"})
    public String getAll(ModelMap model){
        System.out.println("----------getAll()--------");

        /*List<FacultyEntity>faculties = facultyService.getFacultyAll();
        System.out.println("------getAll() Result--------");
        System.out.println("Size:"+ faculties.size());*/

        List<FacultyEntity> faculties = facultyService.getFacultyAll();
        model.addAttribute("faculties",faculties);
        return "faculty/index";
    }

    @GetMapping("/{faculty-id}")
    public String getById(
        ModelMap model,
        @PathVariable(name="faculty-id")Integer facultyId
    ){
        /*System.out.println("---getById()------");
        System.out.println("faculty-id:"+facultyId);*/

        FacultyEntity entity = facultyService.getFacultybyId(facultyId);
        /*System.out.println("------getById() Result--------");
        System.out.println("faculty Name:"+ entity.getFacultyName());*/
        model.addAttribute("faculty",entity);

        List<FacultyEntity> faculties = facultyService.getFacultyAll();
        model.addAttribute("faculties",faculties);
        return "faculty/index";
    }

    @GetMapping("/delete/{faculty-id}")
    public String getDeleteById(
        ModelMap model,
        @PathVariable(name="faculty-id")Integer facultyId
    ){
        /*System.out.println("---getDeleteById()------");
        System.out.println("faculty-id:"+facultyId);

        
        System.out.println("------getDeleteById() Result--------");*/
        facultyService.deleteFacultyById(facultyId);

        List<FacultyEntity> faculties = facultyService.getFacultyAll();
        model.addAttribute("faculties", faculties);
        return "faculty/index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        ModelMap model,
        @RequestParam() Map<String, String>param
        ) {
        
            /*System.out.println("----PostInsertAndUpdate-----");
            System.out.println("faculty-id:"+param.get("faculty-id"));
            System.out.println("faculty-name:"+param.get("faculty-name"));*/

            System.out.println("------PostInsertAndUpdate() Result--------");
            FacultyEntity entity = new FacultyEntity();
            if(null != param.get("faculty-id")){
                entity.setFacultyId(Integer.parseInt(param.get("faculty-id")));
            }
            entity.setFacultyName(param.get("faculty-name"));
            FacultyEntity result = facultyService.saveFaucty(entity);
            /*System.out.println("faculty ID:"+result.getFacultyId());
            System.out.println("faculty Name:"+result.getFacultyName());*/

            List<FacultyEntity> faculties = facultyService.getFacultyAll();
            model.addAttribute("faculties", faculties);

            return "faculty/index";
    }
    
    
}