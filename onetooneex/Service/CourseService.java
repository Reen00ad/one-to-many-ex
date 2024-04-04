package com.example.onetooneex.Service;

import com.example.onetooneex.Api.ApiException;
import com.example.onetooneex.Model.Course;
import com.example.onetooneex.Model.Teacher;
import com.example.onetooneex.Repository.CourseRepository;
import com.example.onetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourse(){

        return courseRepository.findAll();
    }

    public void addCourse(Integer teacher_id,Course course){
        Teacher t=teacherRepository.findTeacherById(teacher_id);
        if(t==null){
            throw new ApiException("can't assign");
        }
        course.setTeacher(t);

        courseRepository.save(course);
    }



    public void updateCourse(Integer id,Course course){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiException("not found");
        }
       c.setName(course.getName());

        courseRepository.save(c);
    }

    public void deleteCourse(Integer id){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiException("not found");
        }

        courseRepository.delete(c);
    }

    public String getTeacherByCourseId(Integer id){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiException(" course not found");
        }

            return c.getTeacher().getName();
    }
}
