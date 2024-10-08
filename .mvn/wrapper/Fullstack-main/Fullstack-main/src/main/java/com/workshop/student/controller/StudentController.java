package com.workshop.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.entity.StudentEntity;
import com.workshop.student.service.FacultyService;
import com.workshop.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping({"","/"})
    public String getAll(){
        System.out.println("----------Studentcontroller getAll()--------");

        List<StudentEntity>student = studentService.getStudentAll();
        System.out.println("-------Studentcontroller getAll() Result--------");
        System.out.println("SIze:"+ student.size());

        return "index";
    }

    @GetMapping("/{student-id}")
    public String getById(
        @PathVariable(name="student-id")Integer studentId
    ){
        System.out.println("----Studentcontroller getById()------");
        System.out.println("student-id:"+studentId);


        StudentEntity entity = studentService.getStudentbyId(studentId);
        System.out.println("-------Studentcontroller getByID() Result-------");
        System.out.println("student First Name:"+entity.getStudentFirstName());
        System.out.println("student LAst Name:"+entity.getStudentLastName());
        return "index";
    }

    @GetMapping("/delete{student-id}")
    public String getDeleteById(
        @PathVariable(name="student-id")Integer studentId
    ){
        System.out.println("---Studentcontroller getDeleteById()------");
        System.out.println("student-id:"+studentId);

        System.out.println("---Studentcontroller getDeleteById() Result------");
        studentService.deleteStudentById(studentId);
        // studentService.de
        return "index";
    }

    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String>param
        ) {
        
            System.out.println("----Studentcontroller PostInsertAndUpdate-----");
            System.out.println("student-id:"+param.get("student-id"));
            System.out.println("student-name:"+param.get("student-name"));
            System.out.println("student-fname:"+param.get("student-fname"));
            System.out.println("student-lname:"+param.get("student-lname"));
            
            System.out.println("faculty-id:"+param.get("faculty-id"));

            System.out.println("----Studentcontroller PostInsertAndUpdate()- Result----");
            Integer facultyId = Integer.parseInt(param.get("faculty-id"));
            FacultyEntity facultyEntity = facultyService.getFacultybyId(facultyId);
            System.out.println("StudentController.postInsertAndUpdate()");
            System.out.println(facultyEntity.getFacultyId());

            StudentEntity entity = new StudentEntity();
            if(null != param.get("student-id")){
                entity.setStudentId(Integer.parseInt(param.get("student-id")));

            }

            entity.setStudentCode(param.get("student-code"));
            entity.setStudentFirstName(param.get("student-fname"));
            entity.setStudentLastName(param.get("student-lname"));
            entity.setFaculty(facultyEntity);

            StudentEntity result = studentService.saveStudent(entity);
            System.out.println("Student ID;"+result.getStudentId());
            System.out.println("Student First Name;"+result.getStudentFirstName());
            System.out.println("Student LastName;"+result.getStudentLastName());
            return "index";
    }
}
