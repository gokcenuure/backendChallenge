package com.enoca.backendChallenge.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    private String password;

    private String position;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


//
//    public Employee(String name, String surname, String phoneNumber, String email, String password, String position, Company company) {
//        this.name = name;
//        this.surname = surname;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.password = password;
//        this.position = position;
//        this.company = company;
//    }
//    public void setCompany(Company companyId) {
//        Company company = new Company();
//        //companyId kullanarak company nesnesi oluşturulur
//        this.company = company;
//    }



}
