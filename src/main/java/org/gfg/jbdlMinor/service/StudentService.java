package org.gfg.jbdlMinor.service;

import org.gfg.jbdlMinor.model.FilterType;
import org.gfg.jbdlMinor.model.Operator;
import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.repository.StudentRepository;
import org.gfg.jbdlMinor.request.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements UserDetailsService {

    @Value("${student.authority}")
    private String studentAuthority;

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        List<Student> studentList = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        Student studentFromDB = null;

        if(studentList == null || studentList.isEmpty()){
            studentCreateRequest.setAuthority(studentAuthority);
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

    @Override
    public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
        List<Student> list = studentRepository.findByPhoneNo(phoneNo);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
