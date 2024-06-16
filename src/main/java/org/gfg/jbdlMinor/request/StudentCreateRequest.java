package org.gfg.jbdlMinor.request;

import jakarta.persistence.Column;
import lombok.*;
import org.gfg.jbdlMinor.model.Student;
import org.gfg.jbdlMinor.model.StudentType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String password;
    private String authority;

    public Student toStudent() {
        return Student.builder().
                name(this.name).
                email(this.email).
                phoneNo(this.phoneNo).
                password(this.password).
                authority(this.authority).
                address(this.address).
                status(StudentType.ACTIVE).
                build();
    }
}
