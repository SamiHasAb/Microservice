package org.study.department.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.study.department.model.Department;
import org.study.department.repository.DepartmentRepository;
@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);

    }

    public Department findDepartmentById(Long departmentId) {

        return departmentRepository.findByDepartmentId(departmentId);

    }

    public  Iterable<Department>  getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long departmentId) {

        //to do return true if succeeded
        departmentRepository.deleteById(departmentId);
    }
}
