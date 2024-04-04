package com.example.onetooneex.Controller;

import com.example.onetooneex.Api.ApiResponse;
import com.example.onetooneex.Model.Course;
import com.example.onetooneex.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course){
        courseService.addCourse(teacher_id,course);
        return ResponseEntity.status(200).body(new ApiResponse("add course and assign to teacher"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course deleted"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherByCourseId(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getTeacherByCourseId(id));
    }

}
