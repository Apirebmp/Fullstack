package com.workshop.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.workshop.student.entity.FacultyEntity;
import com.workshop.student.repository.FacultyRepository;



@Service

public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    

    public List<FacultyEntity> getFacultyAll(){
        return facultyRepository.findAll();
    }


    public FacultyEntity getFacultybyId(Integer facultyId){
        Optional<FacultyEntity> faculty = facultyRepository.findById(facultyId);
        if(faculty.isPresent()){
            return faculty.get();
        }
        return null;
    }


    public FacultyEntity saveFaucty(FacultyEntity facultyEntity){
        FacultyEntity faculty = facultyRepository.save(facultyEntity);
        return faculty;
    }

    public void deleteFacultyById(Integer facultyId){
        facultyRepository.deleteById(facultyId);
    }
}