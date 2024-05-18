package org.gfg.jbdlMinor.service;

import org.gfg.jbdlMinor.model.FilterType;
import org.gfg.jbdlMinor.model.Operator;
import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.repository.StudentRepository;
import org.gfg.jbdlMinor.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        List<Student> studentList = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        Student studentFromDB = null;

        if(studentList == null || studentList.isEmpty()){
            studentFromDB = studentRepository.save(studentCreateRequest.toStudent());
            return studentFromDB;
        }

        studentFromDB = studentList.get(0);
        return studentFromDB;
    }

    public List<Student> filter(FilterType filterBy, Operator operator, String value) {
        switch (operator){
            case EQUALS :
                switch (filterBy){
                    case NAME :
                        return studentRepository.findByName(value);
                    case ADDRESS :
                        return studentRepository.findByAddress(value);
                    case CONTACT:
                        return studentRepository.findByPhoneNo(value);
                }
            default:
                return new ArrayList<>();
        }
    }
}
