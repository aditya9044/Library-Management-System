package org.gfg.jbdlMinor.controller;

import org.gfg.jbdlMinor.model.FilterType;
import org.gfg.jbdlMinor.model.Operator;
import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.request.StudentCreateRequest;
import org.gfg.jbdlMinor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        return studentService.createStudent(studentCreateRequest);
    }

    @GetMapping("/filter")
    public List<Student> filter(@RequestParam("filterBy") FilterType filterBy,
                                @RequestParam("operator") Operator operator,
                                @RequestParam("value") String value){
        return studentService.filter(filterBy,operator,value);
    }
}
