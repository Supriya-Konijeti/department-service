package com.example.demo.service;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    @Override
    public Optional<Department> findDepartment(String id) {
        return departmentDao.findById(id);
    }
    @Override

    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override

    public List<Department> displayAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Department findBydepartmentId(Integer departmentId) {
        return departmentDao.findAll().get(departmentId);
    }
}
