package io.swagger.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class HeaderBean {
    private String xbic;
    private String subjectDN;
    private String institution;


    public String getXbic() {
        return xbic;
    }

    public void setXbic(String xbic) {
        this.xbic = xbic;
    }

    public String getSubjectDN() {
        return subjectDN;
    }

    public void setSubjectDN(String subjectDN) {
        this.subjectDN = subjectDN;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
