package org.gfg.jbdlMinor.service;

import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.repository.StudentRepository;
import org.gfg.jbdlMinor.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Value("${admin.authority}")
    private String adminAuthority;

    @Autowired
    private StudentRepository studentRepository;

    public Student createAdmin(StudentCreateRequest studentCreateRequest) {
        List<Student> studentList = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        Student studentFromDB = null;

        if(studentList == null || studentList.isEmpty()){
            studentCreateRequest.setAuthority(adminAuthority);
            studentFromDB = studentRepository.save(studentCreateRequest.toStudent());
            return studentFromDB;
        }

        studentFromDB = studentList.get(0);
        return studentFromDB;
    }
}
