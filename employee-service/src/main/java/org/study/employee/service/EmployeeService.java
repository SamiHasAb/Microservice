package org.study.employee.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.study.employee.VO.Department;
import org.study.employee.VO.ResponseTempletVO;
import org.study.employee.model.Employee;
import org.study.employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;


    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee of EmployeeService");

        return employeeRepository.save(employee);
    }

    public ResponseTempletVO getEmployeeWithDepartment(long employeeId) {

        //get employee
        Employee emp = employeeRepository.findByEmployeeId(employeeId);

        //calling department-microservice and get the department
        //restTemplet is in the main class

        Department dep =
                restTemplate.getForObject("http://localhost:9001/api/v1/departments/" + emp.getDepartmentId()
                        , Department.class);

        ResponseTempletVO vo = new ResponseTempletVO();
        vo.setEmployee(emp);
        vo.setDepartment(dep);
        return vo;

    }

    public Iterable<ResponseTempletVO> getAllEmployeesWithDepartments() {
        Iterable<Employee> emps = employeeRepository.findAll();

        List<ResponseTempletVO> voList = new ArrayList<ResponseTempletVO>();
        ResponseTempletVO vo = new ResponseTempletVO();
        Department dep ;

        for (Employee emp : emps ) {
           dep = restTemplate.getForObject("http://localhost:9001/api/v1/departments/" + emp.getDepartmentId()
                    , Department.class);

            vo.setEmployee(emp);
            vo.setDepartment(dep);

            voList.add(vo);
        }




        return voList;
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}
