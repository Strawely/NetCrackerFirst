package model;


import model.company.Companies;

import java.util.HashSet;

public interface CompanyModelInterface {
    HashSet<Companies> getCompanies();
    void removeCompany(Companies company);
    void addCompany(Companies company);
}
