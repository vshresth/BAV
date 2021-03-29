package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component("phixiusRequest")
public class PhixiusRequest {

    @JsonProperty("debtorAccount")
    private DebtorAccount debtorAccount;

    @JsonProperty("debtorAgent")
    private DebtorAgent debtorAgent;

    @JsonProperty("cashAccountType")
    private String cashAccountType;

    public DebtorAccount getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(DebtorAccount debtorAccount) {
        this.debtorAccount = debtorAccount;
    }

    public DebtorAgent getDebtorAgent() {
        return debtorAgent;
    }

    public void setDebtorAgent(DebtorAgent debtorAgent) {
        this.debtorAgent = debtorAgent;
    }

    public String getCashAccountType() {
        return cashAccountType;
    }

    public void setCashAccountType(String cashAccountType) {
        this.cashAccountType = cashAccountType;
    }

}

//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("job")
//    private String job;
//
//    public PhixiusRequest(String name, String job) {
//        this.name = name;
//        this.job = job;
//    }
//
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("class PhixiusRequest {\n");
//
//        sb.append("    name: ").append(toIndentedString(name)).append("\n");
//        sb.append("    job: ").append(toIndentedString(job)).append("\n");
//        sb.append("}");
//        return sb.toString();
//    }
//    /**
//     * Convert the given object to string with each line indented by 4 spaces
//     * (except the first line).
//     */
//    private String toIndentedString(java.lang.Object o) {
//        if (o == null) {
//            return "null";
//        }
//        return o.toString().replace("\n", "\n    ");
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//    public String getJob() {
//        return job;
//    }
//}
