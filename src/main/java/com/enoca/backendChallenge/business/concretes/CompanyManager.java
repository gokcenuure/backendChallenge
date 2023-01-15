package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.CompanyService;
import com.enoca.backendChallenge.core.results.*;
import com.enoca.backendChallenge.dataAccess.abstracts.CompanyRepository;
import com.enoca.backendChallenge.entities.concretes.Company;
import com.enoca.backendChallenge.exceptions.CompanyNotFoundException;
import com.enoca.backendChallenge.exceptions.InvalidCompanyIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {


    @Autowired
    public CompanyManager(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private CompanyRepository companyRepository;

    @Override
    public Result create(Company company) {
        try {
            if (company.getCompanyId() == 0) {
                throw new InvalidCompanyIdException("Company id can not be 0");
            }
            this.companyRepository.save(company);
            return new SuccessResult("Company added");
        } catch (InvalidCompanyIdException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }

    @Override
    public Result update(Company company) {
        try {
            Company company1 = this.companyRepository.findById(company.getCompanyId()).orElse(null);
            if (company1 == null) {
                throw new CompanyNotFoundException("Invalid company id");
            }
            company1.setCompanyName(company.getCompanyName());
            companyRepository.save(company1);
            return new SuccessResult("Company updated");
        } catch (CompanyNotFoundException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }


    @Override
    public Result delete(int companyId) {
        try {
            Company company = this.companyRepository.findById(companyId).orElse(null);
            if (company == null) {
                throw new CompanyNotFoundException("Invalid company id");
            }
            companyRepository.delete(company);
            return new SuccessResult("Company deleted");
        } catch (CompanyNotFoundException ex) {
            return new ErrorResult("Error: " + ex.getMessage());
        }
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>(this.companyRepository.findAll(), "Companies listed");
    }

    @Override
    public DataResult<Company> getByCompanyId(int companyId) {
        try {
            Company company = this.companyRepository.findById(companyId).orElse(null);
            if (company == null) {
                throw new CompanyNotFoundException("Invalid company id");
            }
            return new SuccessDataResult<Company>(company, "Company found");
        } catch (CompanyNotFoundException ex) {
            return new ErrorDataResult("Error: " + ex.getMessage());
        }
    }}