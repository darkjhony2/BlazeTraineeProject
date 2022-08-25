package com.jquezada.blazetraineeproject.web.app.domain.generic;

public abstract class CompanyBaseModel extends BaseModel {
    protected String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
