package com.enoca.backendChallenge.controllers;


import com.enoca.backendChallenge.business.abstracts.CompanyService;
import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Company;
import com.enoca.backendChallenge.entities.dtos.CreateCompanyDto;
import com.enoca.backendChallenge.entities.dtos.UpdateCompanyDto;
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
    public Result create(@RequestBody CreateCompanyDto company) {
        return this.companyService.create(company);
    }

    @PutMapping("/company/update/{id}")
    public Result update(@RequestBody UpdateCompanyDto company, @PathVariable int id) {
        return this.companyService.update(company, id);
    }

    @DeleteMapping("/company/delete/{companyId}")
    public Result delete(@PathVariable int companyId) {
        return this.companyService.delete(companyId);
    }

    @GetMapping("/companies")
    public DataResult<List<Company>> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/company/getById/{companyId}")
    public Result getByCompanyId(@PathVariable int companyId) {
        return this.companyService.getByCompanyId(companyId);
    }

}
