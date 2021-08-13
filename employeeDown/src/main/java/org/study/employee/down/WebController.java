package org.study.employee.down;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeServiceFallBack2")
public class WebController {
    @GetMapping("/")
    public String failback(){
       return "Employee Service is taking longer than Expected." +
               " Please try again later";
    }
}
