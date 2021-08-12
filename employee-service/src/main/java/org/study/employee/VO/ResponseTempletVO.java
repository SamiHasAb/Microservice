package org.study.employee.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.employee.model.Employee;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTempletVO {


    private Employee employee;
    private Department department;
}
