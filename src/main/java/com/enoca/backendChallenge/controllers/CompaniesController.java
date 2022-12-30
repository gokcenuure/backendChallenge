package com.enoca.backendChallenge.controllers;


import com.enoca.backendChallenge.business.abstracts.CompanyService;
import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompaniesController {


    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    private CompanyService companyService;


    @PostMapping("/company/add")
    public Result create(@RequestBody Company company) {
        return this.companyService.create(company);
    }
    @PutMapping("/company/update")
    public Result update(Company company) {
        return this.companyService.update(company);
    }

    @DeleteMapping("/company/delete")
    public Result delete(int companyId) {
        return this.companyService.delete(companyId);
    }

    @GetMapping("/companies")
    public DataResult<List<Company>> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/company/getById")
    public Result getByCompanyId(int companyId) {
        return this.companyService.getByCompanyId(companyId);
    }

}
