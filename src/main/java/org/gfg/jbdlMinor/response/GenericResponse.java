package org.gfg.jbdlMinor.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenericResponse<T> {

    private T data;

    private String message;

    private String error;

    private String code;
}
