package org.study.employee.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.study.employee.VO.ResponseTempletVO;
import org.study.employee.model.Employee;
import org.study.employee.service.EmployeeService;

@RequestMapping("/api/v1/employees")
@AllArgsConstructor
@Slf4j

@RestController
public class EmpolyeeController {

    private final EmployeeService employeeService ;


    @PostMapping("/")
    public Employee saveOrUpdateEmployee(@RequestBody Employee employee){

        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseTempletVO getEmployeeAndDepartment(@PathVariable("id") long employeeId  ){

        return employeeService.getEmployeeWithDepartment(employeeId);
    }

    @GetMapping("/all")
    public Iterable<ResponseTempletVO> findAllEmpolyees(){
        return employeeService.getAllEmployeesWithDepartments();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }














}
