package com.enoca.backendChallenge.business.concretes;

import com.enoca.backendChallenge.business.abstracts.CompanyService;
import com.enoca.backendChallenge.core.results.*;
import com.enoca.backendChallenge.dataAccess.abstracts.CompanyRepository;
import com.enoca.backendChallenge.entities.concretes.Company;
import com.enoca.backendChallenge.entities.dtos.CreateCompanyDto;
import com.enoca.backendChallenge.entities.dtos.UpdateCompanyDto;
import com.enoca.backendChallenge.exceptions.CompanyNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {


    @Autowired
    public CompanyManager(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    private CompanyRepository companyRepository;
    private ModelMapper modelMapper;

    @Override
    public Result create(CreateCompanyDto company) {
        Company companyToCreate = modelMapper.map(company, Company.class);
        this.companyRepository.save(companyToCreate);
        return new SuccessResult("Company added");
    }

    @Override
    public Result update(UpdateCompanyDto company, int id) {
            Company UpdateCompanyDto = modelMapper.map(company, Company.class);
            Company companyToUpdate = this.getByCompanyId(id).getData();

            companyToUpdate.setCompanyName(company.getCompanyName());

            companyRepository.save(companyToUpdate);
            return new SuccessResult("Company updated");

    }


    @Override
    public Result delete(int companyId) {
            Company company = this.getByCompanyId(companyId).getData();
            return new SuccessResult("Company deleted");
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