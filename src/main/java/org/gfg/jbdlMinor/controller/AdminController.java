package org.gfg.jbdlMinor.controller;

import org.gfg.jbdlMinor.model.FilterType;
import org.gfg.jbdlMinor.model.Operator;
import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.request.StudentCreateRequest;
import org.gfg.jbdlMinor.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Student createAdmin(@RequestBody StudentCreateRequest studentCreateRequest){
        return adminService.createAdmin(studentCreateRequest);
    }
}
