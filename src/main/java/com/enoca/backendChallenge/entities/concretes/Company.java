package com.enoca.backendChallenge.entities.concretes;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    private String companyName;

    /*@OneToMany
    @JoinTable(name = "company_employee",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))   */

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Employee> employees;

//
//    public Company(String companyName) {
//        this.companyName = companyName;
//        this.employees = new ArrayList<Employee>();
//    }
//
//    public void addEmployee(Employee employee) {
//        employee.setCompany(this);
//        this.employees.add(employee);
//    }



    /*
    @OneToMany(mappedBy = "company")
    public List<Employee> employees;
*/
}
