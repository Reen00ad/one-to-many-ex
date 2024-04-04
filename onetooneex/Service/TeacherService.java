package com.example.onetooneex.Service;

import com.example.onetooneex.Api.ApiException;
import com.example.onetooneex.Model.Teacher;
import com.example.onetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeacher(){

        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher t =teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("not found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());

        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher t =teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("not found");
        }


        teacherRepository.delete(t);
    }

    public Teacher getTeachers(Integer id){
        Teacher t =teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException("not found");
        }
        return t;
    }







}
