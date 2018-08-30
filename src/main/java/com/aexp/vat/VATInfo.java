package com.aexp.vat;

import com.aexp.model.Company;

public class VATInfo {
   private boolean valid;
   private Company company;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
