package com.demo.springapplication.library.common.model.mb;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseStatusCustomCode implements Serializable {
    private String code;
    private String header;
    private String description;

    public ResponseStatusCustomCode(String code) {
        this.code = code;
    }

    public ResponseStatusCustomCode(Integer code) {
        this.code = String.valueOf(code);
    }

    public ResponseStatusCustomCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ResponseStatusCustomCode(Integer code, String description) {
        this.code = String.valueOf(code);
        this.description = description;
    }

    public ResponseStatusCustomCode(Integer code, String header, String description) {
        this.code = String.valueOf(code);
        this.header = header;
        this.description = description;
    }
}
