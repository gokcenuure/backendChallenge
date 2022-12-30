package com.enoca.backendChallenge.business.abstracts;

import com.enoca.backendChallenge.core.results.DataResult;
import com.enoca.backendChallenge.core.results.Result;
import com.enoca.backendChallenge.entities.concretes.Company;

import java.util.List;

public interface CompanyService {

    Result create(Company company);

    Result update(Company company);

    Result delete(int companyId);

    DataResult<List<Company>> getAll();

    DataResult<Company> getByCompanyId(int companyId);
}
