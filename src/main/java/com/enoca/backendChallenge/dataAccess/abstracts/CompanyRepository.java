package com.enoca.backendChallenge.dataAccess.abstracts;

import com.enoca.backendChallenge.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Company getByCompanyId(Integer companyId);

}
