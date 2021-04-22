package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String EmployeeName;
}
