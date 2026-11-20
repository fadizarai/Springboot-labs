package tn.tp.dev.Student_service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponse {
    private String id;
    private String name;
    private Course course;
}