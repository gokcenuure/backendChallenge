package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.CompanyService;
import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.core.results.SuccessDataResult;
import com.enoca.backendChallenge.core.results.SuccessResult;
import com.enoca.backendChallenge.dataAccess.abstracts.CompanyRepository;
import com.enoca.backendChallenge.entities.concretes.Company;
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
        this.companyRepository.save(company);
        return new SuccessResult("Company added");
    }

    @Override
    public Result update(Company company) {
        Company company1 = this.companyRepository.findById(company.getCompanyId()).orElse(null);

        company1.setCompanyName(company.getCompanyName());

        companyRepository.save(company1);

        return new SuccessResult("Car updated");
    }

    @Override
    public Result delete(int companyId) {
        Company company = this.companyRepository.findById(companyId).orElse(null);
        companyRepository.delete(company);
        return new SuccessResult("Company deleted");
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>(this.companyRepository.findAll(), "Companies listed");
    }

    @Override
    public DataResult<Company> getByCompanyId(int companyId) {
        return new SuccessDataResult<Company>(this.companyRepository.getByCompanyId(companyId),"Company found");
    }
}
