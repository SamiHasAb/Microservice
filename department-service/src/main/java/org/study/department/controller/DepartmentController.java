package org.study.department.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.study.department.model.Department;
import org.study.department.service.DepartmentService;

@RequestMapping("/api/v1/departments")
@AllArgsConstructor
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/")
    public Department addOrUpdateDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId ){

        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/all")
    public Iterable<Department>  findAllDepartment(){


        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
        try {
            departmentService.deleteDepartment(departmentId);
        }
        catch(Exception e) {

        }

    }

}
