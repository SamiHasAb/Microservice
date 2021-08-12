package org.study.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotBlank(message = "* first name is required")
    @Size(min = 1, max = 20 ,message =" minimum 1 character and maximum 20 characters" )
    private String firstName;

    @NotBlank(message = "* last name is required")
    @Size(min = 1, max = 20 ,message =" minimum 1 character and maximum 20 characters" )
    private String lastName;

    @Email(message = "* enter a valid email")
    private String email;

    private Long departmentId;

}
