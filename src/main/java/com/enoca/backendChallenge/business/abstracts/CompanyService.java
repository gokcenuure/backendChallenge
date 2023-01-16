package com.enoca.backendChallenge.business.abstracts;

import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Company;
import com.enoca.backendChallenge.entities.dtos.CreateCompanyDto;
import com.enoca.backendChallenge.entities.dtos.UpdateCompanyDto;

import java.util.List;

public interface CompanyService {

    Result create(CreateCompanyDto company);

    Result update(UpdateCompanyDto company, int id);

    Result delete(int companyId);

    DataResult<List<Company>> getAll();

    DataResult<Company> getByCompanyId(int companyId);
}
