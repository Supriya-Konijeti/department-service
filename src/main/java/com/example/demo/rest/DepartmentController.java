package com.example.demo.rest;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> displayAll()
    {
        return new ResponseEntity<List<Department>>(departmentService.displayAllDepartment(),HttpStatus.OK);
    }
    @GetMapping("/departments/departmentId")
    public ResponseEntity<Department> displayById(@PathVariable("departmentId") Integer departmentId )
    {
        return new ResponseEntity<Department>(departmentService.findBydepartmentId(departmentId),HttpStatus.OK);
    }
    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable("id") String id)
    {
        return ResponseEntity.ok(departmentService.findDepartment(id));
    }
    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<List<Department>> deleteDepartment(@PathVariable("id") String id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}

